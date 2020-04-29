package com.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.clases.codigueras.CodRol;
import com.dao.CodRolDao;
import com.dao.CodRolDaoImpl;

/**
 * Session Bean implementation class CodTipoDocumentoBean
 */
@Stateless
public class CodTipoDocumentoBean implements CodTipoDocumentoBeanRemote {

    /**
     * Default constructor. 
     */
    public CodTipoDocumentoBean() {
        // TODO Auto-generated constructor stub
    }
    
	
	/*@Override
	public List<CodTipo_Documento> retornarTiposDocumento() {
		this.tipoDocumentoDao = new CodTipoDocumentoDao();
		return this.rolDao.obtenerCodRol();
	}*/

}
