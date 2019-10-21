package com.beans;

import javax.ejb.Remote;

import com.entities.Fenomeno;
import com.exceptions.DBHandlerException;

@Remote
public interface BAMFenomenosBeanRemote {

	public void ingresaFenomeno(Fenomeno fenomeno) throws DBHandlerException;
	public void eliminarFenomeno(Fenomeno fenomeno )  throws DBHandlerException;
	public void modificarFenomeno(String nombre, Fenomeno fenomeno )  throws DBHandlerException;
	 
	
}
