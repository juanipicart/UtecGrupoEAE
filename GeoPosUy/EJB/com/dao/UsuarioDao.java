package com.dao;

import javax.ejb.Remote;

import com.clases.Usuario;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@Remote
public interface UsuarioDao {
	
	public void registrarUsuario(Usuario usu) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public boolean eliminarUsuario(long idUsuario) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public boolean modificarUsuario(Usuario usu) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	boolean chequearSiExisteUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public Usuario buscarUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
}
