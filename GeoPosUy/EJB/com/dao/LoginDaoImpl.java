package com.dao;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bd.DBConector;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@Stateless
@LocalBean
public class LoginDaoImpl implements LoginDao {

	DBConector bd = DBConector.getinstance();
	
	
	@Override
	public boolean validarLogueo(String username, String password) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		
		String VALIDAR_LOGIN = "SELECT * FROM USUARIOS where usuario = ? AND password = ?"; 
		
		int i;
		
		// se prepara el insert
		bd.setPrepStmt(VALIDAR_LOGIN);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, username.toUpperCase());
			bd.getPrepStmt().setString(2, password.toUpperCase());
			
			
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		
		i= bd.execDML();		
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Login fallido");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Login fallido");
		} else
			System.out.println("Datos validos para login");	
		return true;
		
	}
	
}
