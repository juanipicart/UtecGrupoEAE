package com.test;

import java.util.List;

import com.clases.codigueras.CodZona;
import com.dao.ubicaciones.CodZonasDao;
import com.dao.ubicaciones.CodZonasDaoImpl;

public class PruebaZonas {

	public static void main(String[] args) {

		CodZonasDao dao = new CodZonasDaoImpl();
		List<CodZona> zona = null;
		int i =0;
		
		//CodZona clzona = new CodZona(0, "Cabe zona");
		//CodZona clzona2 = new CodZona(0, "Cabe Cita");
		//
		zona = dao.obtenerCodZonaLike("Cab");
		
		try {
			//dao.eliminarCodZona(zona.get(0).getIdCodZona());
			
			//dao.actualizarCodZona(zona.get(0).getIdCodZona(), clzona2.getDescCodZona());
			//dao.ingresarCodZona(clzona.getDescCodZona());
		} catch ( Exception e){
			System.out.println(" Error -->" +e.getMessage() );
		}
		
		
		zona = null;
		//zona = dao.obtenerCodZona("NortE");
		//zona = dao.obtenerCodZonaLike("cab");
		zona = dao.obtenerCodZona();		
		
		System.out.println("Cantidad de objetos : " +zona.size()); 
				
		while ( zona.size() > i) {
			
			System.out.println("La lista de objetos es: descripcion: " +zona.get(i).getDescCodZona() 
					+" indice " +zona.get(i).getIdCodZona());
			i++;
		}
	}

}
