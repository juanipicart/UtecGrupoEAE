package com.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Fenomeno;
import com.exceptions.DBHandlerException;

/**
 * Session Bean implementation class BAMFenomenosBean
 */
@Stateless
@LocalBean
public class BAMFenomenosBean implements BAMFenomenosBeanRemote {

 
	@PersistenceContext
    private EntityManager eMFenomenos;	
 	
    public BAMFenomenosBean() {
        // TODO Auto-generated constructor stub
    }

    // dar de alta  (clase ya viene cargada)*///    
    public void ingresaFenomeno(Fenomeno fenomeno) throws DBHandlerException {
    	try {
    	eMFenomenos.persist(fenomeno);
    	eMFenomenos.flush();
    	} catch ( Exception e) {
    		throw new DBHandlerException("Error al persistir Ingresar Fenomeno");
		}
    }
    
    // dar de baja */// 
    public void eliminarFenomeno(Fenomeno fenomeno )  throws DBHandlerException {
    	try {
   		// buscar id a borrar
    	long id = devolverID(fenomeno.getNombre());
    	Fenomeno f = eMFenomenos.find(Fenomeno.class, id);
    	
    	// verificar que no esta aplicado 
    	if (hayObservacionesConFenomeno(f)) {
    		throw new DBHandlerException("El fenomeno con nombre=" +f.getNombre()+" e id=" + f.getIdFenomeno() + " existe" );
    	}
    	
    	eMFenomenos.remove(f);
    	eMFenomenos.flush();
    	} catch ( Exception e) {
    		throw new DBHandlerException("Error al borrar Fenomeno");
		}
	}
    
    // modificar un fenomeno X nombre */// 
    public void modificarFenomeno( String nombre, Fenomeno fenomeno )  throws DBHandlerException {
    	try {
    	// buscar id a borrar
    	long id = devolverID(nombre);
    	eMFenomenos.find(Fenomeno.class, id);
    	
    	eMFenomenos.merge(fenomeno);
    	eMFenomenos.flush();
    	} catch ( Exception e) {
    		throw new DBHandlerException("Error al modificar fenomeno " + nombre);
		}
	}
     
    // modificar un fenomeno X clases */// 
    ///////////////////////////////
    // Funcionalidad en pruebas ///
    ///////////////////////////////
    public void modificarFenomeno( Fenomeno old, Fenomeno nuevo )  throws DBHandlerException {
    	try {
    	eMFenomenos.detach( old );
    	
    	eMFenomenos.merge(nuevo);
    	eMFenomenos.flush();
    	} catch ( Exception e) {
    		throw new DBHandlerException("Error al modificar fenomeno " + old.getNombre());
		}
	}
    
    // Buscar si un fenomeno está asignado a una observacion
    // retorna TRUE si encuentra
    private boolean hayObservacionesConFenomeno (Fenomeno fen) throws DBHandlerException {
    	//
       	try {
       		// consulto el id por el nombre
  	    	String qry = "Select count(*) from OBSERVACIONES_FENOMENOS where ID_FENOMENO = ?";
	    	Query query = eMFenomenos.createNativeQuery( qry );
	    	query.setParameter(1, fen.getIdFenomeno());
	    	Integer i = (Integer) query.getSingleResult();
	    	
	    	if ( i.intValue() > 0 ) {
	    		return true;
	    	}
	    	return false;
    	} catch ( Exception e) {
    		throw new DBHandlerException("Error al buscar id del Fenomeno");
		}
    }

    
    // devolver id de un nombre
    private long devolverID (String nombre) throws DBHandlerException {
       	try {
       		// consulto el id por el nombre
       		TypedQuery<Fenomeno> query = eMFenomenos.createQuery("SELECT f FROM Fenomeno f WHERE f.nombre :nom", Fenomeno.class);
        	
       		return query.setParameter("nom", nombre).getSingleResult().getIdFenomeno();
       		
        	} catch ( Exception e) {
        		throw new DBHandlerException("Error al buscar id del Fenomeno");
    		}
    }

    
}
