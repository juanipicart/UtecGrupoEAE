package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bd.DBConector;
import com.clases.Fenomeno;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@LocalBean
@Stateless
public class FenomenoDaoImpl implements FenomenoDao {
	
	DBConector bd = DBConector.getinstance();
	
	private static final String crearFenomeno = "INSERT INTO FENOMENOS (NOMBRE,DESCRIPCION,CONTACTO_EMERGENCIA,CODIGO) VALUES (UPPER(?),UPPER(?),UPPER(?),UPPER(?))";
	private static final String actualizarFenomeno = "UPDATE FENOMENOS SET NOMBRE=UPPER(?),DESCRIPCION=UPPER(?),CONTACTO_EMERGENCIA=UPPER(?) WHERE CODIGO=?";
	private static final String borrarFenomeno = "DELETE FROM FENOMENOS WHERE ID_FENOMENO = ?";
	private static final String selectTodosFenomenos = "SELECT * FROM FENOMENOS";
	private static final String selectFenomenoPorCodigo = "SELECT * FROM FENOMENOS WHERE CODIGO = UPPER(?)";
	private static final String selectFenomenoPorNombre = "SELECT * FROM FENOMENOS WHERE NOMBRE = UPPER(?)";

		
	@Override
	public void registrarFenomeno(Fenomeno fenomeno) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
		bd.setPrepStmt(crearFenomeno);
		
		try {
			
			bd.getPrepStmt().setString(1, fenomeno.getNombre());
			bd.getPrepStmt().setString(2, fenomeno.getDescripcion());
			bd.getPrepStmt().setString(3, fenomeno.getContacto_emergencia());
			bd.getPrepStmt().setString(4, fenomeno.getCodigo());
			
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		
		int i = bd.execDML();
		
		// Ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Insertar usuario");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Insertar usuario");
		} else
			System.out.println("Se complet� el registro del fenomeno");		
			
	}
	
	@Override
	public void actualizarFenomeno(Fenomeno fenomeno) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
		bd.setPrepStmt(actualizarFenomeno);
		
		try {
			bd.getPrepStmt().setString(1, fenomeno.getNombre());
			bd.getPrepStmt().setString(2, fenomeno.getDescripcion());
			bd.getPrepStmt().setString(3, fenomeno.getContacto_emergencia());
			bd.getPrepStmt().setString(4, fenomeno.getCodigo());
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		} 
		int i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Modificar fen�meno");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Modificar fen�meno");
		} else
			System.out.println("Se actualiz� el fen�meno");	

	}

	@Override
	public void eliminarFenomeno(Fenomeno fenomeno) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {

		bd.setPrepStmt(borrarFenomeno);
		
		try {
			bd.getPrepStmt().setLong(1, fenomeno.getId_fenomeno());
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		
		int i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Eliminar usuario");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Eliminar usuario");
		} else
			System.out.println("Se elimin� el usuario");

	}

	@Override
	public LinkedList<Fenomeno> selectTodosFenomenos() throws Exception {
		LinkedList<Fenomeno> fenomenos = new LinkedList<>();
		bd.setPrepStmt(selectTodosFenomenos);
		
		try {
						
			ResultSet resultado = bd.getPrepStmt().executeQuery();
			
			while (resultado.next()) {
				Fenomeno fenomeno = getFenomenoDesdeResultado(resultado);
				fenomenos.add(fenomeno);			
			} return fenomenos;
		} catch (ProblemasNivelSQLException e) {
			throw new ProblemasNivelSQLException("Realizar b�squeda");
		}

	}

	@Override
	public Fenomeno selectFenomenoPorCodigo(String codigo) throws Exception
	{

		Fenomeno fenomeno = null;
		bd.setPrepStmt(selectFenomenoPorCodigo);
		
		try { 
			bd.getPrepStmt().setString(1, codigo);
			bd.execQry();
			
			ResultSet resultado = bd.getResultSet();
			
			while (resultado.next()) {
				fenomeno = getFenomenoDesdeResultado(resultado);
			} }
		 catch (ProblemasNivelSQLException e) {
			throw new ProblemasNivelSQLException("realizar b�squeda");
		} return fenomeno;
	}
	
	@Override
	public Fenomeno selectFenomenoPorNombre(String nombre) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
		Fenomeno fenomeno = null;
		bd.setPrepStmt(selectFenomenoPorNombre);
		
		try {
			bd.getPrepStmt().setString(1, nombre);
			bd.execQry();
			
			ResultSet resultado = bd.getResultSet();
			
			while (resultado.next()) {
				fenomeno = getFenomenoDesdeResultado(resultado);
			} return fenomeno;
		} catch (ProblemasNivelSQLException | SQLException e) {
			throw new ProblemasNivelSQLException("realizar b�squeda");
		}
	}


	private static Fenomeno getFenomenoDesdeResultado(ResultSet resultado) throws ProblemasNivelSQLException {
		
	try {
		Long id_fenomeno = resultado.getLong("ID_FENOMENO");
		String codigo = resultado.getString("CODIGO");
		String nombre = resultado.getString("NOMBRE");
		String descripcion = resultado.getString("DESCRIPCION");
		String contacto = resultado.getString("CONTACTO_EMERGENCIA");
		
		Fenomeno fenomeno = new Fenomeno(id_fenomeno, nombre, descripcion, contacto);
		fenomeno.setCodigo(codigo);
		
		return fenomeno; 
	} catch (SQLException e) {
		throw new ProblemasNivelSQLException("realizar operaci�n");
		
	}

	}
}


