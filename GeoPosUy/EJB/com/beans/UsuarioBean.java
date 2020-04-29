package com.beans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.clases.Usuario;
import com.clases.codigueras.CodRol;
import com.clases.relaciones.RelUbicacion;
import com.dao.UsuarioDao;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@EJB
	UsuarioDao servicio;	
	
    public UsuarioBean() {    	
    
    }
    
	@Override
	public int registrarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password, String documento, int estado, int rol, int tipodoc, String correo,
			RelUbicacion ubicacion) {
		
		int numeroError = 0;
		
		if(usuario == null || usuario == "" || usuario.length() > 15) {			

			numeroError = 1;
			return numeroError;
		}
		if(nombre == null || nombre == "" || nombre.length() > 30) {			
			numeroError = 2;
			return numeroError;
		}
		if(apellido == null || apellido == "" || apellido.length() > 30) {			
			numeroError = 3;
			return numeroError;
		}
		if(direccion == null || direccion == "" || direccion.length() > 60) {			
			numeroError = 4;
			return numeroError;
		}
		if(direccion == null || direccion == "") {			
			numeroError = 5;
			return numeroError;
		}
		if(password == null || password == "" || password.length() > 30) {			
			numeroError = 6;
			return numeroError;
		}
		if(ubicacion == null) {			
			numeroError = 7;
			return numeroError;
		}
		if(documento == null || documento == "" || documento.length() > 30) {			
			numeroError = 8;
			return numeroError;
		}
		
		Usuario usuarioACrear = new Usuario(id, usuario, nombre, apellido, direccion, password, documento,estado,rol,tipodoc,correo, ubicacion);

		boolean existe = false;
		
		try {
			
			 existe = ExisteUsuario(usuario);
			
		} catch (ProblemasNivelSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSeRealizoOperacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(existe) {
			numeroError = 7;
			return numeroError;
		}else {
			try {
				servicio.registrarUsuario(usuarioACrear);
			} catch (ProblemasNivelSQLException | NoSeRealizoOperacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return numeroError;
	}
	
	
	
	@Override
	public int modificarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password, String documento, int estado, int rol, int tipodoc, String correo,
			RelUbicacion ubicacion) {
		boolean modifico = false;
		int numeroError = 0;
		
		if(id == -1) {
			numeroError = 7;
			return numeroError;
		}
		if(usuario == null || usuario == "" || usuario.length() > 15) {			
			//Captar del otro lado este numero y mostrar el mensaje error correspondiente, lo mismo con las otras verificaciones
			numeroError = 1;
			return numeroError;
		}
		if(nombre == null || nombre == "" || nombre.length() > 30) {			
			numeroError = 2;
			return numeroError;
		}
		if(apellido == null || apellido == "" || apellido.length() > 30) {			
			numeroError = 3;
			return numeroError;
		}
		if(direccion == null || direccion == "" || direccion.length() > 60) {			
			numeroError = 4;
			return numeroError;
		}
		if(ubicacion == null) {			
			numeroError = 5;
			return numeroError;
		}
		if(rol == 0) {			
			numeroError = 6;
			return numeroError;
		}
		
		Usuario usuarioACrear = new Usuario(id, usuario, nombre, apellido, direccion, password, documento,estado,rol,tipodoc,correo, ubicacion);
		
		try {
			
			modifico = servicio.modificarUsuario(usuarioACrear);
			
		} catch (ProblemasNivelSQLException | NoSeRealizoOperacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(modifico) {
			numeroError = 0;
		}
		return numeroError;
	}
	
	
	@Override
    public boolean ExisteUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
    	boolean existe = servicio.chequearSiExisteUsuario(username);
    	
    	return existe;
    }
	
	@Override
    public Usuario buscarUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
		Usuario usu = new Usuario();
		
    	usu = servicio.buscarUsuario(username);
    	
    	//El error estaba en el constructor jeje!
    	
    	return usu;
    }

	@Override
	public boolean eliminarUsuario(long idUsuario) {

		boolean logrado = false;
		
		try {
			
			return logrado = servicio.eliminarUsuario(idUsuario);
			
		} catch (ProblemasNivelSQLException | NoSeRealizoOperacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logrado;
	}

}
