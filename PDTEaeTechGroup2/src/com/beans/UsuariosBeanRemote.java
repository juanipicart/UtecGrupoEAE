package com.beans;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface UsuariosBeanRemote {


	void crearUsuario(Usuario usuario);
	

}
