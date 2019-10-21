package com.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entities.*;

@Stateless
public class UbicacionesBean implements UbicacionesBeanRemote {

	 @PersistenceContext
	    EntityManager em;
	    
	 public void crearUbicacion(int id_depto, int id_local, int id_zona) {
		 Ubicacion ubicacion = new Ubicacion();
		 Departamento depto = em.find(Departamento.class, id_depto);
		 Localidad local = em.find(Localidad.class, id_local);
		 Zona zona = em.find(Zona.class, id_zona);
		 ubicacion.setDepartamento(depto);
		 ubicacion.setLocalidad(local);
		 ubicacion.setZona(zona);
		 em.persist(ubicacion);
		 em.flush();
		 em.close();
	 }
	    
    public UbicacionesBean() {
    }
    
   

}
