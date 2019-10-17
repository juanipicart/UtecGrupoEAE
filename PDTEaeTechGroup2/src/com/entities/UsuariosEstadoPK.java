package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIOS_ESTADOS database table.
 * 
 */
@Embeddable
public class UsuariosEstadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private long idUsuario;

	@Column(name="ID_ESTADO", insertable=false, updatable=false)
	private long idEstado;

	public UsuariosEstadoPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdEstado() {
		return this.idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosEstadoPK)) {
			return false;
		}
		UsuariosEstadoPK castOther = (UsuariosEstadoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idEstado == castOther.idEstado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idEstado ^ (this.idEstado >>> 32)));
		
		return hash;
	}
}