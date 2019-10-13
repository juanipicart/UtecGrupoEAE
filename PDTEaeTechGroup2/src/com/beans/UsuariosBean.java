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
    private EntityManager em;
	
    public UsuariosBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void crearUsuario(String username, String nombre, String apellido, String direccion, int id_ubicacion, int id_rol)  {
		
			Usuario usuario = new Usuario();
			usuario.setUsuario(username);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setUbicacion(em.find(Ubicacion.class, id_ubicacion));
			usuario.setRol(em.find(Rol.class, id_rol));
			em.persist(usuario);
			em.flush();
		}
		
	}


