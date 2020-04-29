package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bd.DBConector;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodRol;

public class CodRolDaoImpl implements CodRolDao{


DBConector bd = DBConector.getinstance();
	
	
	private static String TODOS = "Select * from COD_ROLES order by DESCRIPCION_ROL";
	
	ArrayList<CodRol> lsdto;
@Override
public List<CodRol> obtenerCodRol() {
	
	lsdto = new ArrayList<>();	
	try {
		bd.execStmt(TODOS);
		
		while ( bd.getResultSet().next()) {
			CodRol dto = new CodRol();
			dto.setId_rol(bd.getResultSet().getInt(1));
			dto.setDescripcion_rol(bd.getResultSet().getString(2));
			dto.setId_estado(bd.getResultSet().getInt(3));
			dto.setFecha_desde(bd.getResultSet().getDate(4));
			lsdto.add(dto);
		}
	} catch (SQLException e) {
		System.out.println("Excepcion al consultar Rol  por Descripcion -->" + e.getMessage());
		e.printStackTrace();
	}		
	return lsdto;
}


}
