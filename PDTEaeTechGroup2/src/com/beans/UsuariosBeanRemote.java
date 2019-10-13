package com.beans;

import javax.ejb.Remote;

@Remote
public interface UsuariosBeanRemote {

	void crearUsuario(String username, String nombre, String apellido, String direccion, int id_ubicacion, int id_rol);
	

}
