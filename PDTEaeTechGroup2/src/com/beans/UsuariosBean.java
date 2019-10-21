package com.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entities.*;

/**
 * Session Bean implementation class UsuariosBean
 */
@Stateless
public class UsuariosBean implements UsuariosBeanRemote {

	@PersistenceContext
    EntityManager em;
		
	public void crearUsuario(Usuario usuario, int id_rol, int id_ubicacion) {
		Rol rol = em.find(Rol.class, id_rol);
		Ubicacion ubicacion = em.find(Ubicacion.class, id_ubicacion);
		usuario.setUbicacion(ubicacion);
		usuario.setRol(rol);
		em.persist(usuario);
		em.flush();
		em.close();
	}
	
    public UsuariosBean() {
    }

	@Override
	public void crearUsuario(Usuario usuario, Rol rol, Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		
	}

    
    
    


	
		
	}


