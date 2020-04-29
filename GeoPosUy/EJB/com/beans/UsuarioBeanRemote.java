package com.beans;

import javax.ejb.Remote;

import com.clases.Usuario;
import com.clases.codigueras.CodRol;
import com.clases.relaciones.RelUbicacion;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@Remote
public interface UsuarioBeanRemote {


	boolean ExisteUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;

	int registrarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password,
			String documento, int estado, int rol, int tipodoc, String correo, RelUbicacion ubicacion);

	Usuario buscarUsuario(String username) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;

	int modificarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password,
			String documento, int estado, int rol, int tipodoc, String correo, RelUbicacion ubicacion);

	boolean eliminarUsuario(long idUsuario);

}
