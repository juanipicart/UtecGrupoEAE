package com.test;

import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.beans.UbicacionesBeanRemote;
import com.beans.UsuarioBean;
import com.beans.UsuarioBeanRemote;
import com.clases.Usuario;
import com.clases.codigueras.CodEstado;
import com.clases.codigueras.CodRol;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;
import com.dao.UsuarioDao;
import com.dao.UsuarioDaoImpl;
import com.dao.ubicaciones.CodLocalidadesDao;
import com.dao.ubicaciones.CodLocalidadesDaoImpl;
import com.dao.ubicaciones.CodZonasDaoImpl;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

public class PruebaUsuario {


	
	public static void main(String[] args) {
		
		UsuarioBeanRemote usu = new UsuarioBean();

		
		Long idRol = (long) 10;
		Long id = new Long(100);
		Long idZona = new Long(12);
		Long idLocalidad = new Long(244);
		Long estado = new Long(5);
		Date now = new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		
		CodEstado est = new CodEstado(estado, "Activo");
		
		RelUbicacion ubi = new RelUbicacion(id, idLocalidad, "S", idZona);
		
		//CodRol rol = new CodRol(idRol, "Coso", est, sqlDate);		
		
		//int asd = usu.registrarUsuario(id, "nachomanya","ignacio","rosales", "cruz del sur", "12345", ubi, rol);
		
		//System.out.println(asd);

	}

}
