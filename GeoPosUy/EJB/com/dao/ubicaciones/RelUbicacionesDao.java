package com.dao.ubicaciones;

import java.util.List;

import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

public interface RelUbicacionesDao {

	public void ingresarUbicacion(RelUbicacion ubicacion) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public void borrarUbicacion(RelUbicacion ubicacion) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public void actualizarUbicacion(RelUbicacion ubicacionOld, RelUbicacion ubicacionNew) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	
	public List<RelUbicacion> obtenerUbicacion(CodZona zona, CodDepartamento depto, CodLocalidad localidad); //<<-- todas 
	public List<RelUbicacion> obtenerUbicacion(CodZona zona); // todas por zona
	public List<RelUbicacion> obtenerUbicacion(CodDepartamento depto); // todas por departamento 
	public List<RelUbicacion> obtenerUbicacion(CodLocalidad localidad); // todas por localidad
	public List<RelUbicacion> obtenerUbicacion(RelUbicacion ubicacion); //obtener por id (lo toma adentro)
	
}
