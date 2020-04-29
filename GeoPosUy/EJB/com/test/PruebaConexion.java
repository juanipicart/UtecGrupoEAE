package com.test;

import java.sql.SQLException;

import com.bd.DBConector;

public class PruebaConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConector bd = DBConector.getinstance();
		String str = "LO";
		
		//String sql = "select count(*) from cod_localidades  where localidad =?";
		String sql2 = "select count(*) from cod_localidades  where localidad like '%" +str +"%'";
		
				
//		bd.setPrepStmt(sql);
//		
//		
//		try {
//			bd.getPrepStmt().setString(1,str);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		bd.execQry();

		bd.execStmt(sql2);
		
		int i = -1;
		try {
			
			bd.getResultSet().next();
			i = bd.getResultSet().getInt(1);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" Valor de la cantidad :" + i);
		
		

	}

}
