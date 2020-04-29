package com.clases.codigueras;

import java.io.Serializable;

public class CodDepartamento implements Serializable{
	
	// Codiguera de codigos de Departamentos
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCodDepartamento;
	private String descCodDepartamento;

	public CodDepartamento() {
		this.idCodDepartamento = null;
		this.descCodDepartamento = null;
	}
	
	public CodDepartamento(String idCodDepartamento, String descCodDepartamento) {
		this.idCodDepartamento = idCodDepartamento;
		this.descCodDepartamento = descCodDepartamento;
	}

	public String getIdCodDepartamento() {
		return idCodDepartamento;
	}

	public void setIdCodDepartamento(String idCodDepartamento) {
		this.idCodDepartamento = idCodDepartamento;
	}

	public String getDescCodDepartamento() {
		return descCodDepartamento;
	}

	public void setDescCodDepartamento(String descCodDepartamento) {
		this.descCodDepartamento = descCodDepartamento;
	}
	
}
