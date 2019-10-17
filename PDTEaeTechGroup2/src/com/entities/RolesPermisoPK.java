package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ROLES_PERMISOS database table.
 * 
 */
@Embeddable
public class RolesPermisoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ROL", insertable=false, updatable=false)
	private long idRol;

	@Column(name="ID_MODULO", insertable=false, updatable=false)
	private long idModulo;

	public RolesPermisoPK() {
	}
	public long getIdRol() {
		return this.idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	public long getIdModulo() {
		return this.idModulo;
	}
	public void setIdModulo(long idModulo) {
		this.idModulo = idModulo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolesPermisoPK)) {
			return false;
		}
		RolesPermisoPK castOther = (RolesPermisoPK)other;
		return 
			(this.idRol == castOther.idRol)
			&& (this.idModulo == castOther.idModulo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idRol ^ (this.idRol >>> 32)));
		hash = hash * prime + ((int) (this.idModulo ^ (this.idModulo >>> 32)));
		
		return hash;
	}
}