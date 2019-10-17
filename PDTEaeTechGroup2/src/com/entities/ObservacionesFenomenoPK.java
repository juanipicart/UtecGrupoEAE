package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OBSERVACIONES_FENOMENOS database table.
 * 
 */
@Embeddable
public class ObservacionesFenomenoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_OBSERVACION", insertable=false, updatable=false)
	private long idObservacion;

	@Column(name="ID_FENOMENO", insertable=false, updatable=false)
	private long idFenomeno;

	@Column(name="ID_CARACTERISTICA", insertable=false, updatable=false)
	private long idCaracteristica;

	public ObservacionesFenomenoPK() {
	}
	public long getIdObservacion() {
		return this.idObservacion;
	}
	public void setIdObservacion(long idObservacion) {
		this.idObservacion = idObservacion;
	}
	public long getIdFenomeno() {
		return this.idFenomeno;
	}
	public void setIdFenomeno(long idFenomeno) {
		this.idFenomeno = idFenomeno;
	}
	public long getIdCaracteristica() {
		return this.idCaracteristica;
	}
	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObservacionesFenomenoPK)) {
			return false;
		}
		ObservacionesFenomenoPK castOther = (ObservacionesFenomenoPK)other;
		return 
			(this.idObservacion == castOther.idObservacion)
			&& (this.idFenomeno == castOther.idFenomeno)
			&& (this.idCaracteristica == castOther.idCaracteristica);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idObservacion ^ (this.idObservacion >>> 32)));
		hash = hash * prime + ((int) (this.idFenomeno ^ (this.idFenomeno >>> 32)));
		hash = hash * prime + ((int) (this.idCaracteristica ^ (this.idCaracteristica >>> 32)));
		
		return hash;
	}
}