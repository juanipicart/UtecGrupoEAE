package com.beans;

import java.util.List;

import javax.ejb.Remote;

import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodRol;

@Remote
public interface CodRolBeanRemote {

	List<CodRol> retornarRoles();

}
