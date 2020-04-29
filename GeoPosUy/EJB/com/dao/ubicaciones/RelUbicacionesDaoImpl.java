package com.dao.ubicaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.bd.DBConector;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;


public class RelUbicacionesDaoImpl implements RelUbicacionesDao {

	/// Declaracion de SQL y DML 	
	private static String SELECT_GENERAL = "Select ID_UBICACION, ID_LOCALIDAD, ID_DEPARTAMENTO, ID_ZONA from REL_UBICACIONES";
	///
	private static String INSERTAR = "Insert into REL_UBICACIONES (ID_UBICACION, ID_LOCALIDAD, ID_DEPARTAMENTO, ID_ZONA) Values(NULL, ?, UPPER(?), ?)"; 
	private static String ELIMINAR = "Delete from REL_UBICACIONES where ID_UBICACION= ?";
	private static String ACTUALIZAR = "Update REL_UBICACIONES set ID_LOCALIDAD =?, ID_DEPARTAMENTO =UPPER(?), ID_ZONA =? where ID_UBICACION= ?";
	
	private static String TODOS_POR_TODO_ID		= SELECT_GENERAL + "  Where ID_ZONA=? and ID_DEPARTAMENTO=UPPER (?) and ID_LOCALIDAD=?";
	private static String TODOS_POR_LOCALIDAD		= SELECT_GENERAL + "  Where ID_LOCALIDAD=?";
	private static String TODOS_POR_ZONA 			= SELECT_GENERAL + " Where ID_ZONA=?"; 
	private static String TODOS_POR_DEPARTAMENTO 	= SELECT_GENERAL + " Where ID_DEPARTAMENTO=UPPER (?)"; 
	private static String POR_ID_OBSERVACION 		= SELECT_GENERAL + " Where ID_UBICACION=?"; 
	
	
	// traigo la instancia ya hecha o va nueva 
	DBConector bd = DBConector.getinstance();
	
	ArrayList<RelUbicacion> lsUbicacion;

	@Override
	public void ingresarUbicacion(RelUbicacion ubicacion) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {

		int i;
		try {
			bd.setPrepStmt(INSERTAR);
			bd.getPrepStmt().setLong(1, ubicacion.getIdLoc());
			bd.getPrepStmt().setString(2, ubicacion.getIdDepto());
			bd.getPrepStmt().setLong(3, ubicacion.getIdZona());
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("INSERTAR Ubicacion");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("INSERTAR Ubicacion");
		} else
			System.out.println("Se insertaron ["+i+"] registros");
	}

	@Override
	public void borrarUbicacion(RelUbicacion ubicacion) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		int i;
		try {
			bd.setPrepStmt(ELIMINAR);
			bd.getPrepStmt().setLong(1, ubicacion.getIdUbicacion());
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("ELIMINAR Ubicacion");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("ELIMINAR Ubicacion");
		} else
			System.out.println("Se ELIMINARON ["+i+"] registros");
	}

	@Override
	public void actualizarUbicacion(RelUbicacion ubicacionOld, RelUbicacion ubicacionNew) throws ProblemasNivelSQLException, NoSeRealizoOperacionException {
		int i;
		try {
			bd.setPrepStmt(ACTUALIZAR);
			bd.getPrepStmt().setLong(1, ubicacionNew.getIdLoc());
			bd.getPrepStmt().setString(2, ubicacionNew.getIdDepto());
			bd.getPrepStmt().setLong(3, ubicacionNew.getIdZona());
			bd.getPrepStmt().setLong(4, ubicacionOld.getIdUbicacion());
		} catch (SQLException e) {
			throw new ProblemasNivelSQLException(e.getMessage());
		}
		i= bd.execDML();
		
		// ejecutamos y controlamos retorno
		if ( i == 0) {
			throw new NoSeRealizoOperacionException("INSERTAR Ubicacion");
		} else if (i < 0) {
			throw new  ProblemasNivelSQLException("INSERTAR Ubicacion");
		} else
			System.out.println("Se insertaron ["+i+"] registros");
		
	}

	@Override
	public List<RelUbicacion> obtenerUbicacion(CodZona zona) {
		try {		
			bd.setPrepStmt(TODOS_POR_ZONA);
			lsUbicacion = new ArrayList<>();

			bd.getPrepStmt().setLong(1, zona.getIdCodZona());
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				// llama al metodo para llenar cada campo en la clase
				lsUbicacion.add( llenarClaseConResultado());
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar obtenerUbicacion por zona-->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsUbicacion;
	}

	@Override
	public List<RelUbicacion> obtenerUbicacion(CodDepartamento depto) {
		try {		
			bd.setPrepStmt(TODOS_POR_DEPARTAMENTO);
			lsUbicacion = new ArrayList<>();

			bd.getPrepStmt().setString(1, depto.getIdCodDepartamento());
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				// llama al metodo para llenar cada campo en la clase
				lsUbicacion.add( llenarClaseConResultado());
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar obtenerUbicacion por departamento-->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsUbicacion;
	}

	@Override
	public List<RelUbicacion> obtenerUbicacion(CodLocalidad localidad) {
		try {		
			bd.setPrepStmt(TODOS_POR_LOCALIDAD);
			lsUbicacion = new ArrayList<>();

			bd.getPrepStmt().setLong(1, localidad.getIdCodLocalidad());
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				// llama al metodo para llenar cada campo en la clase
				lsUbicacion.add( llenarClaseConResultado());
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar obtenerUbicacion por localidad-->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsUbicacion;
	}

	@Override
	public List<RelUbicacion> obtenerUbicacion(RelUbicacion ubicacion) {
		try {		
			bd.setPrepStmt(POR_ID_OBSERVACION);
			lsUbicacion = new ArrayList<>();

			bd.getPrepStmt().setLong(1, ubicacion.getIdUbicacion());
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				// llama al metodo para llenar cada campo en la clase
				lsUbicacion.add( llenarClaseConResultado());
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar obtenerUbicacion por ID-->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsUbicacion;
	}

	@Override
	public List<RelUbicacion> obtenerUbicacion(CodZona zona, CodDepartamento depto, CodLocalidad localidad) {
		try {		
			bd.setPrepStmt(TODOS_POR_TODO_ID);
			lsUbicacion = new ArrayList<>();

			bd.getPrepStmt().setLong(1, zona.getIdCodZona());
			bd.getPrepStmt().setString(2, depto.getIdCodDepartamento());
			bd.getPrepStmt().setLong(3, localidad.getIdCodLocalidad()) ;
			bd.execQry();
			
			while ( bd.getResultSet().next()) {
				// llama al metodo para llenar cada campo en la clase
				lsUbicacion.add( llenarClaseConResultado());
			}
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar obtenerUbicacion por todos ids-->" + e.getMessage());
			e.printStackTrace();
		}		
		return lsUbicacion;
	}
	
	public RelUbicacionesDaoImpl() {

	}

	private RelUbicacion llenarClaseConResultado() throws SQLException {
		RelUbicacion rel = new RelUbicacion();
		rel.setIdUbicacion(bd.getResultSet().getLong(1));
		rel.setIdLoc(bd.getResultSet().getLong(2));
		rel.setIdDepto(bd.getResultSet().getString(3));
		rel.setIdZona(bd.getResultSet().getLong(4));
		return rel;
	}



}
