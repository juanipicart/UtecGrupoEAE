package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USUARIOS_PASSWD database table.
 * 
 */
@Embeddable
public class UsuariosPasswdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USER", insertable=false, updatable=false)
	private long idUser;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HASTA")
	private java.util.Date fechaHasta;

	public UsuariosPasswdPK() {
	}
	public long getIdUser() {
		return this.idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public java.util.Date getFechaHasta() {
		return this.fechaHasta;
	}
	public void setFechaHasta(java.util.Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosPasswdPK)) {
			return false;
		}
		UsuariosPasswdPK castOther = (UsuariosPasswdPK)other;
		return 
			(this.idUser == castOther.idUser)
			&& this.fechaHasta.equals(castOther.fechaHasta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUser ^ (this.idUser >>> 32)));
		hash = hash * prime + this.fechaHasta.hashCode();
		
		return hash;
	}
}