package com.clases.codigueras;

public class CodTipo_Documento {
	long ID_TIPO_DOC;
	String TIPO;

	public CodTipo_Documento(long iD_TIPO_DOC, String tIPO) {
		super();
		ID_TIPO_DOC = iD_TIPO_DOC;
		TIPO = tIPO;
	}
	
	public CodTipo_Documento() {
		// TODO Auto-generated constructor stub
	}

	public long getID_TIPO_DOC() {
		return ID_TIPO_DOC;
	}
	public void setID_TIPO_DOC(long iD_TIPO_DOC) {
		ID_TIPO_DOC = iD_TIPO_DOC;
	}
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}

	
	
}
