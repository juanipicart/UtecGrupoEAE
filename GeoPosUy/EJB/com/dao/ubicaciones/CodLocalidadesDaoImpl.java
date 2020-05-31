package com.dao.ubicaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bd.DBConector;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

public class CodLocalidadesDaoImpl implements CodLocalidadesDao {

	/// Declaracion de SQL y DML 	
	/*private static String INS_LOC = "Insert into localidades Values(NULL,UPPER(?))"; 
	private static String DEL_LOC = "Delete from localidades where id_localidad= ?";
	private static String UPD_LOC = "Update localidades set localidad = UPPER(?) where id_localidad= ?";*/
	
	private static String TODOS = "Select * from localidades order by localidad";
	private static String TODOS_POR_DEPTO = "Select * from localidades WHERE id_depto =? order by localidad asc";
	private static String TODOS_POR_ID = "Select * from localidades Where id_localidad=?"; 
	//private static String TODOS_POR_LOCALIDAD = "Select * from localidades Where localidad= UPPER ( ? )";
	//private static String TODOS_POR_LOCALIDAD_LIKE = "Select * from localidades Where localidad LIKE UPPER( '%' || ? || '%')";
	// traigo la instancia ya hecha o va nueva 
	DBConector bd = DBConector.getinstance();
	ArrayList<CodLocalidad> lsloc;
	CodDepartamentosDaoImpl cod = new CodDepartamentosDaoImpl();
	//SE PUEDE BORRAR
	//@Override
	/*public void actualizarCodLocalidad(long idLocalidadOld, String descLocalidadNueva) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		int i;
		bd.setPrepStmt(UPD_LOC);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, descLocalidadNueva);
			bd.getPrepStmt().setLong(2, idLocalidadOld);
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("actualizar Localidad");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("actualizar Localidad");
		} else
			System.out.println("Se actualizaron ["+i+"] registros");
	}*/

	/*@Override
	public void ingresarCodLocalidad(String descLocalidad) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		int i;
		// se prepara el insert
		bd.setPrepStmt(INS_LOC);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, descLocalidad);
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Insertar Localidad");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Insertar Localidad");
		} else
			System.out.println("Se ingresaron ["+i+"] registros");
	}*/

	/*@Override
	public void eliminarCodLocalidad(long idLocalidad) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		int i;
		// se prepara el delete
		bd.setPrepStmt(DEL_LOC);
		
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setLong(1, idLocalidad);
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("Borrar Localidad");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("Borrar Localidad");
		} else
			System.out.println("Se borró ["+i+"] registros");
	}*/

	//@Override
	/*public List<CodLocalidad> obtenerCodLocalidad(String descLocalidad) {
		
		bd.setPrepStmt(TODOS_POR_LOCALIDAD);
		lsloc = new ArrayList<>();
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, descLocalidad);
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				CodLocalidad loc = new CodLocalidad();
				loc.setIdCodLocalidad(bd.getResultSet().getLong(1));
				loc.setDescCodLocalidad(bd.getResultSet().getString(2));
				lsloc.add(loc);
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar Localidad por Descripcion -->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsloc;
	}*/

	/*@Override
	public List<CodLocalidad> obtenerCodLocalidadLike(String descLocalidad) {
		
		bd.setPrepStmt(TODOS_POR_LOCALIDAD_LIKE);
		lsloc = new ArrayList<>();
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, descLocalidad);
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				CodLocalidad loc = new CodLocalidad();
				loc.setIdCodLocalidad(bd.getResultSet().getLong(1));
				loc.setDescCodLocalidad(bd.getResultSet().getString(2));
				lsloc.add(loc);
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar Localidad por Descripcion -->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsloc;
	}*/
	
	/*@Override
	public List<CodLocalidad> obtenerLocalidadesPorDepto(String depto) {

		List<CodDepartamento> lsdto = cod.obtenerCodDepartamento(depto);
		depto = lsdto.get(0).getIdCodDepartamento();
		
		bd.setPrepStmt(TODOS_POR_DEPTO);
		lsloc = new ArrayList<>();
		//El asignar una variable puede lanzar una excepcion de SQL
		try {
			bd.getPrepStmt().setString(1, depto);
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				CodLocalidad loc = new CodLocalidad();
				loc.setIdCodLocalidad(bd.getResultSet().getLong(1));
				loc.setDescCodLocalidad(bd.getResultSet().getString(2));
				lsloc.add(loc);
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar Localidad por Descripcion -->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsloc;
	}
*/
	public CodLocalidadesDaoImpl() {

	}

	@Override
	public List<CodLocalidad> obtenerCodLocalidad() {
		
		lsloc = new ArrayList<>();
		try {
			bd.execStmt(TODOS);
			
			while ( bd.getResultSet().next()) {
				CodLocalidad loc = new CodLocalidad();
				loc.setIdCodLocalidad(bd.getResultSet().getLong(1));
				loc.setDescCodLocalidad(bd.getResultSet().getString(2));
				lsloc.add(loc);
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar Localidad por Descripcion -->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsloc;
	}



}
