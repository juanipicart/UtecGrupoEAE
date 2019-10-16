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
	
    public UsuariosBean() {
    }
    
    
    
    Rol rol = em.find(Rol.class, 1);
    
    Ubicacion ubicacion = em.find(Ubicacion.class, 1);
    
    Usuario usuario = new Usuario("juani", "Juan", "Picart", "Ni idea", ubicacion, rol);
    
    @Override
	public void crearUsuario(Usuario usuario)  {
			em.persist(usuario);
			em.flush();
		}

	
		
	}


