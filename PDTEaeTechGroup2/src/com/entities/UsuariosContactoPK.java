package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIOS_CONTACTOS database table.
 * 
 */
@Embeddable
public class UsuariosContactoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	@Column(name="ID_TIPO", insertable=false, updatable=false)
	private long idTipo;

	public UsuariosContactoPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosContactoPK)) {
			return false;
		}
		UsuariosContactoPK castOther = (UsuariosContactoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idTipo == castOther.idTipo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idTipo ^ (this.idTipo >>> 32)));
		
		return hash;
	}
}