package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ObservacionesCriticidadPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_OBSERVACION", insertable=false, updatable=false)
	private long idObservacion;

	@Column(name="ID_NIVEL", insertable=false, updatable=false)
	private long idNivel;

	public ObservacionesCriticidadPK() {
	}
	public long getIdObservacion() {
		return this.idObservacion;
	}
	public void setIdObservacion(long idObservacion) {
		this.idObservacion = idObservacion;
	}
	public long getIdNivel() {
		return this.idNivel;
	}
	public void setIdNivel(long idNivel) {
		this.idNivel = idNivel;
	}

	// obligado poner esto
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObservacionesCriticidadPK)) {
			return false;
		}
		ObservacionesCriticidadPK castOther = (ObservacionesCriticidadPK)other;
		return 
			(this.idObservacion == castOther.idObservacion)
			&& (this.idNivel == castOther.idNivel);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idObservacion ^ (this.idObservacion >>> 32)));
		hash = hash * prime + ((int) (this.idNivel ^ (this.idNivel >>> 32)));
		
		return hash;
	}
}