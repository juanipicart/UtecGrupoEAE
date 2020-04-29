package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bd.DBConector;
import com.clases.Usuario;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@Stateless
@LocalBean
public class UsuarioDaoImpl implements UsuarioDao {
	
	DBConector bd = DBConector.getinstance();

	@Override
	public void registrarUsuario(Usuario usu) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		String INS_USU = "Insert into USUARIOS Values(NULL,?,?,?,?,?,?,?,?,?,?,?)"; 
		int i;
		
		// se prepara el insert
		bd.setPrepStmt(INS_USU);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, usu.getUsuario().toUpperCase());
			bd.getPrepStmt().setString(2, usu.getNombre().toUpperCase());
			bd.getPrepStmt().setString(3, usu.getApellido().toUpperCase());
			bd.getPrepStmt().setString(4, usu.getDireccion().toUpperCase());
			bd.getPrepStmt().setLong(5, usu.getUbicacion().getIdUbicacion());
			bd.getPrepStmt().setString(6, usu.getCorreo());		
			bd.getPrepStmt().setString(7, usu.getDocumento());	
			bd.getPrepStmt().setInt(8, usu.getTipodoc());	
			bd.getPrepStmt().setString(9, usu.getPassword().toUpperCase());
			bd.getPrepStmt().setInt(10, usu.getRol());	
			bd.getPrepStmt().setInt(11, usu.getEstado());	

			
			
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		
		i= bd.execDML();		
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Insertar usuario");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Insertar usuario");
		} else
			System.out.println("Se ingresaron ["+i+"] registros");	
		
	}
	
	

	
	
	@Override
	public boolean modificarUsuario(Usuario usu) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		String UPD_USU = "Update USUARIOS set ID_USER = ?, USUARIO = ?, NOMBRE = ?, APELLIDO = ?, DIRECCION = ?, ID_UBICACION = ?, CORREO = ?, DOCUMENTO = ?, TIPO_DOC = ?, PASSWORD = ?, ROL = ?, ESTADO = ? where ID_USER=" + usu.getId_user() + "";
		int i;
		boolean exito = false;
		// se prepara el insert
		bd.setPrepStmt(UPD_USU);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setLong(1, usu.getId_user());
			bd.getPrepStmt().setString(2, usu.getUsuario().toUpperCase());
			bd.getPrepStmt().setString(3, usu.getNombre().toUpperCase());
			bd.getPrepStmt().setString(4, usu.getApellido().toUpperCase());
			bd.getPrepStmt().setString(5, usu.getDireccion().toUpperCase());
			bd.getPrepStmt().setLong(6, usu.getUbicacion().getIdUbicacion());
			bd.getPrepStmt().setString(7, usu.getCorreo().toUpperCase());
			bd.getPrepStmt().setString(8, usu.getDocumento().toUpperCase());
			bd.getPrepStmt().setInt(9, usu.getTipodoc());
			bd.getPrepStmt().setString(10, usu.getPassword().toUpperCase());
			bd.getPrepStmt().setInt(11, usu.getRol());
			bd.getPrepStmt().setInt(12, usu.getEstado());
			
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Modificar usuario");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Modificar usuario");
		} else {
			System.out.println("Se modificaron ["+i+"] registros");	
		exito = true;
		}
		return exito;
	}
	
	@Override
	public boolean chequearSiExisteUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		final String selectUsuarioPorUsername = "SELECT * FROM USUARIOS WHERE USUARIO = ?";
		boolean existe = false;
		bd.setPrepStmt(selectUsuarioPorUsername);
		
		try {
			bd.getPrepStmt().setString(1, username);
			bd.execQry();
			
			ResultSet resultado = bd.getResultSet();
			
			while (resultado.next()) {
				existe = true;
			}
			return existe;
			
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException("realizar búsqueda");
		}
	}
	
	
	@Override
	public Usuario buscarUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		final String selectUsuarioPorUsername = "SELECT ID_USER, USUARIO, NOMBRE, APELLIDO, DIRECCION, CORREO, DOCUMENTO, PASSWORD, TIPO_DOC, ID_UBICACION, ESTADO, ROL FROM USUARIOS WHERE USUARIO = ?";
		bd.setPrepStmt(selectUsuarioPorUsername);
		Usuario usuario = null;
		System.out.println("llego");
		try {
			bd.getPrepStmt().setString(1, username);
			bd.execQry();
			
			ResultSet resultado = bd.getResultSet();
			while (resultado.next()) {				
				usuario = getUsuarioDesdeResultado(resultado);
			}
			return usuario;
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException("realizar búsqueda");
		}
	}
	
private static Usuario getUsuarioDesdeResultado(ResultSet resultado) throws ProblemasNivelSQLException {
		
		try {
			System.out.println("asd");
			
			long id_user = resultado.getLong("ID_USER");
			String usuario = resultado.getString("USUARIO");
			String nombre = resultado.getString("NOMBRE");
			String apellido = resultado.getString("APELLIDO");
			String direccion = resultado.getString("DIRECCION");
			String correo = resultado.getString("CORREO");
			String documento = resultado.getString("DOCUMENTO");
			String password = resultado.getString("PASSWORD");
			int tipo_doc = resultado.getInt("TIPO_DOC");
			int id_ubicacion = resultado.getInt("ID_UBICACION");
			int id_rol = resultado.getInt("ROL");
			int estado = resultado.getInt("ESTADO");
			
			Usuario user = new Usuario(id_user, usuario, nombre, apellido,direccion, password,documento,estado,id_rol,tipo_doc, correo, id_ubicacion);
			System.out.println(user.getApellido());
			
			return user; 
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException("realizar operación");
			
		}
	}





@Override
public boolean eliminarUsuario(long idUsuario) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
	
	String DEL_USU = "Delete from USUARIOS where ID_USER= ?";
	int i;
	boolean logrado = false;
	
	bd.setPrepStmt(DEL_USU);
	

	try {
		bd.getPrepStmt().setLong(1, idUsuario);			
	} catch (SQLException e) {
		throw new ProblemasNivelSQLException(e.getMessage());
	}
	i= bd.execDML();
	
	// ejecutamos y controlamos retorno
	if ( i == 0) {
		throw new NoSeRealizoOperacionException("Eliminar usuario");
	} else if (i < 0) {
		throw new  ProblemasNivelSQLException("Eliminar usuario");
	} else {
		System.out.println("Se eliminaron ["+i+"] registros");
	logrado = true;
	}
	
	return logrado;	
}

	/*public Usuario selectUsuarioPorUsername(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		private static final String selectUsuarioPorUsername = "SELECT * FROM USUARIOS WHERE USUARIO = ?";
		Usuario usuario = null;
		bd.setPrepStmt(selectUsuarioPorUsername);
		
		try {
			bd.getPrepStmt().setString(1, usesrname);
			bd.execQry();
			
			ResultSet resultado = bd.getResultSet();
			
			while (resultado.next()) {
				usuario = getFenomenoDesdeResultado(resultado);
			} return usuario;
		} catch (ProblemasNivelSQLException | SQLException e) {
			throw new ProblemasNivelSQLException("realizar búsqueda");
		}
	}
	
	private static Usuario getUsuarioDesdeResultado(ResultSet resultado) throws ProblemasNivelSQLException {
		
		try {
			Long id_user = resultado.getLong("ID_USER");
			String usuario = resultado.getString("USUARIO");
			String nombre = resultado.getString("NOMBRE");
			String apellido = resultado.getString("APELLIDO");
			String direccion = resultado.getString("DIRECCION");
			Long id_ubicacion = resultado.getLong("ID_UBICACION");
			Long id_rol = resultado.getLong("ID_ROL");
			
			Ubicacion ubicacion = getUbicacionDesdeId();
			
			Usuario user = new Usuario(id_user, usuario, nombre, apellido,direccion,id_ubicacion,id_rol);
			
			return user; 
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException("realizar operación");
			
		}
	}
		
		private static Usuario getUbicacionDesdeId(ResultSet resultado) throws ProblemasNivelSQLException {
			
			try {
				Long id_ubicacion = resultado.getLong("ID_UBICACION");
				Long id_localidad = resultado.getLong("ID_LOCALIDAD");
				String id_departamento = resultado.getString("ID_DEPARTAMENTO");
				Long id_zona = resultado.getLong("ID_ZONA");

				
				Ubicacion ubi = new Ubicacion(id_ubicacion, id_localidad, id_departamento, id_zona);
				
				return user; 
			} catch (SQLException e) {
				throw new ProblemasNivelSQLException("realizar operación");
				
			}
			
			
}
		
private static Usuario getLocalidadPorId(ResultSet resultado) throws ProblemasNivelSQLException {
			
			try {
				Long id_ubicacion = resultado.getLong("ID_UBICACION");
				Long id_localidad = resultado.getLong("ID_LOCALIDAD");
				String id_departamento = resultado.getString("ID_DEPARTAMENTO");
				Long id_zona = resultado.getLong("ID_ZONA");

				
				Ubicacion ubi = new Ubicacion(id_ubicacion, id_localidad, id_departamento, id_zona);
				
				return user; 
			} catch (SQLException e) {
				throw new ProblemasNivelSQLException("realizar operación");
				
			}
}*/
}