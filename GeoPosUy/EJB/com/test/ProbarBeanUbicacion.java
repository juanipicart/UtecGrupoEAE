package com.test;

import com.beans.UbicacionesBean;
import com.clases.UbicacionesObj;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodZona;

public class ProbarBeanUbicacion {

	public static void main(String[] args) {
		// 
		UbicacionesObj uo = new UbicacionesObj();
		long i = 0 ; 
		long id = 289;
	
		CodZona classZona = new CodZona(); 
		CodDepartamento classDto = new CodDepartamento();
		CodLocalidad classLoc = new CodLocalidad();
		
		classZona.setIdCodZona(1);
		classDto.setIdCodDepartamento("a");
		classLoc.setIdCodLocalidad(19);
		
		UbicacionesObj u = new UbicacionesObj( classZona, classDto, classLoc );
		
		UbicacionesBean bn = new UbicacionesBean();
		
		//i = bn.registrarUbicacion(u);
		uo = bn.devolverObjUbicacion(id);
		
		System.out.println("Resulado del registro = " +i);
		
	}

}
