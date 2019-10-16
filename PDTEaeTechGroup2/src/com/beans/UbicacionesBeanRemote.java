package com.beans;

import javax.ejb.Remote;

@Remote
public interface UbicacionesBeanRemote {
	
	void crearUbicacion(int id_depto, int id_local, int id_zona);

}
