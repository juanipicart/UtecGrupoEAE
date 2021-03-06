package com.dao;

import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.clases.Observacion;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;

@Remote
public interface ObservacionDao {

	public void registrarObservacion(Observacion obs) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public void eliminarObservacion(long id_observacion) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public void modificarObservacion(Observacion obs) throws ProblemasNivelSQLException, NoSeRealizoOperacionException;
	public boolean buscarObsPorFenomeno(String fenomeno) throws ProblemasNivelSQLException, NoSeRealizoOperacionException, SQLException, Exception;	
}
