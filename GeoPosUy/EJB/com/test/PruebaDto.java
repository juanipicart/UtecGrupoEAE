package com.test;

import java.util.List;

import com.clases.codigueras.CodDepartamento;
import com.dao.ubicaciones.CodDepartamentosDao;
import com.dao.ubicaciones.CodDepartamentosDaoImpl;

public class PruebaDto {

	public static void main(String[] args) {
		CodDepartamentosDao dao = new CodDepartamentosDaoImpl();
		List<CodDepartamento> dto = null;
		int i =0;
		
		//CodDepartamento cdto = new CodDepartamento("Z", "Cabe algo");
		
		//
		//dto = dao.obtenerCodDepartamentoLike("CAbe");
		
	
		try {
			//dao.eliminarCodDepartamento(dto.get(0).getIdCodDepartamento());
			
			//dao.actualizarCodDepartamento(dto.get(0).getIdCodDepartamento(), cdto.getDescCodDepartamento());
		
			//dao.ingresarCodDepartamento(cdto.getIdCodDepartamento(), cdto.getDescCodDepartamento());
		} catch ( Exception e){
			System.out.println(" Error -->" +e.getMessage() );
		}
		
		
		//dto = dao.obtenerCodDepartamentoId("t");
		//dto = dao.obtenerCodDepartamento("cerro largo");
		dto = dao.obtenerCodDepartamento();
		//dto = dao.obtenerCodZona(3);		
		
		System.out.println("Cantidad de objetos : " +dto.size()); 
				
		while ( dto.size() > i) {
			
			System.out.println("La lista de objetos es: ID: " +dto.get(i).getIdCodDepartamento() 
					+" Descripion " +dto.get(i).getDescCodDepartamento());
			i++;
		}
	}

}
