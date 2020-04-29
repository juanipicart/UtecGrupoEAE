package com.test;

import java.util.List;

import com.clases.codigueras.CodLocalidad;
import com.dao.ubicaciones.CodLocalidadesDao;
import com.dao.ubicaciones.CodLocalidadesDaoImpl;

public class PruebaLocalidad {

	public static void main(String[] args) {
		
		
		CodLocalidadesDao dao = new CodLocalidadesDaoImpl();
		List<CodLocalidad> lsloc = null;
		int i =0;
		
		//CodLocalidad clloc = new CodLocalidad(0, "Cabe zona");
		//CodLocalidad clloc = new CodLocalidad(0, "ARA mINDA");
		//
		//lsloc = dao.obtenerCodLocalidad("ARA mINDA");
		
		try {
			//dao.eliminarCodLocalidad(lsloc.get(0).getIdCodLocalidad());
			
			//dao.actualizarCodLocalidad(lsloc.get(0).getIdCodLocalidad(), clloc.getDescCodLocalidad());
			//dao.ingresarCodLocalidad(clloc.getDescCodLocalidad());
		} catch ( Exception e){
			System.out.println(" Error -->" +e.getMessage() );
		}
		
		
		lsloc = null;
		//lsloc = dao.obtenerCodLocalidad("ARAMINDA");
		//lsloc = dao.obtenerCodLocalidadLike("ARA");
		lsloc = dao.obtenerCodLocalidad();		
		
		System.out.println("Cantidad de objetos : " +lsloc.size()); 
				
		while ( lsloc.size() > i) {
			
			System.out.println("La lista de objetos es: descripcion: [" +lsloc.get(i).getDescCodLocalidad() 
					+"] indice " +lsloc.get(i).getIdCodLocalidad());
			i++;
		}
	}

}
