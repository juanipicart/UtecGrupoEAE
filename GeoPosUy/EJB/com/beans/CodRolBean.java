package com.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodRol;
import com.dao.CodRolDao;
import com.dao.CodRolDaoImpl;
import com.dao.ubicaciones.CodDepartamentosDao;
import com.dao.ubicaciones.CodDepartamentosDaoImpl;
import com.dao.ubicaciones.CodLocalidadesDao;
import com.dao.ubicaciones.CodZonasDao;

/**
 * Session Bean implementation class RolBean
 */
@Stateless
public class CodRolBean implements CodRolBeanRemote {

    /**
     * Default constructor. 
     */
    public CodRolBean() {
        // TODO Auto-generated constructor stub
    }

    private CodRolDao rolDao;
	
	@Override
	public List<CodRol> retornarRoles() {
		this.rolDao = new CodRolDaoImpl();
		return this.rolDao.obtenerCodRol();
	}
    
}
