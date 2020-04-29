package com.test;

import java.util.List;

import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;
import com.dao.ubicaciones.RelUbicacionesDao;
import com.dao.ubicaciones.RelUbicacionesDaoImpl;

public class PruebaUbicacion {

	public static void main(String[] args) {

		int i =0;
		RelUbicacionesDao dao = new RelUbicacionesDaoImpl();
		
		List<RelUbicacion> lstUbicacion = null;

		CodLocalidad cl = new CodLocalidad();
		CodZona cz = new CodZona();
		CodDepartamento cd = new CodDepartamento(); 
		RelUbicacion ru = new RelUbicacion();
		
/*
		try {
			//dao.eliminarCodLocalidad(lsloc.get(0).getIdCodLocalidad());
			
			//dao.actualizarCodLocalidad(lsloc.get(0).getIdCodLocalidad(), clloc.getDescCodLocalidad());
			//dao.ingresarCodLocalidad(clloc.getDescCodLocalidad());
		} catch ( Exception e){
			System.out.println(" Error -->" +e.getMessage() );
		}
*/		
		//ru.setIdUbicacion(225);
		//cl.setIdCodLocalidad(19);
		//cz.setIdCodZona(3);
		cd.setIdCodDepartamento("q");
		
		lstUbicacion = dao.obtenerUbicacion(cd);		
		System.out.println("Cantidad de objetos : " +lstUbicacion.size()); 
		while ( lstUbicacion.size() > i) {
			
			System.out.println("La lista de objetos es: [" +lstUbicacion.get(i).getIdUbicacion() +"]-"
					+"[" +lstUbicacion.get(i).getIdLoc() +"]-"
					+"[" +lstUbicacion.get(i).getIdDepto() +"]-"
					+"[" +lstUbicacion.get(i).getIdZona() +"]-");

			i++;
		}

	}

}
