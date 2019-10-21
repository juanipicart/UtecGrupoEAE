package com.beans;

import javax.ejb.Remote;

import com.entities.Rol;
import com.entities.Ubicacion;
import com.entities.Usuario;

@Remote
public interface UsuariosBeanRemote {


	void crearUsuario(Usuario usuario, Rol rol, Ubicacion ubicacion);
	

}
