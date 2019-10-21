package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIOS_DOCUMENTOS database table.
 * 
 */
@Embeddable
public class UsuariosDocumentoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	@Column(name="ID_TIPO_DOC", insertable=false, updatable=false)
	private long idTipoDoc;

	public UsuariosDocumentoPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdTipoDoc() {
		return this.idTipoDoc;
	}
	public void setIdTipoDoc(long idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosDocumentoPK)) {
			return false;
		}
		UsuariosDocumentoPK castOther = (UsuariosDocumentoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idTipoDoc == castOther.idTipoDoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idTipoDoc ^ (this.idTipoDoc >>> 32)));
		
		return hash;
	}
}