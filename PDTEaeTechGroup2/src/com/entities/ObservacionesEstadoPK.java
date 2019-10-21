package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ObservacionesEstadoPK implements Serializable {
	private static final long serialVersionUID = 1L;
// no se deja actualizar o insertar, solo leer
	@Column(name="ID_OBSERVACION", insertable=false, updatable=false)
	private long idObservacion;

	@Column(name="ID_ESTADO", insertable=false, updatable=false)
	private long idEstado;

	public ObservacionesEstadoPK() {
	}
	public long getIdObservacion() {
		return this.idObservacion;
	}
	public void setIdObservacion(long idObservacion) {
		this.idObservacion = idObservacion;
	}
	public long getIdEstado() {
		return this.idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}


	// metodos obligados.. no se para que sirven
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObservacionesEstadoPK)) {
			return false;
		}
		ObservacionesEstadoPK castOther = (ObservacionesEstadoPK)other;
		return 
			(this.idObservacion == castOther.idObservacion)
			&& (this.idEstado == castOther.idEstado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idObservacion ^ (this.idObservacion >>> 32)));
		hash = hash * prime + ((int) (this.idEstado ^ (this.idEstado >>> 32)));
		
		return hash;
	}
}