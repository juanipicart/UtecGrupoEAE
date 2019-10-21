package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ObservacionesImagenPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ID_OBSERVACION", insertable=false, updatable=false)
	private long idObservacion;

	private String archivo;

	public ObservacionesImagenPK() {
	}
	public long getIdObservacion() {
		return this.idObservacion;
	}
	public void setIdObservacion(long idObservacion) {
		this.idObservacion = idObservacion;
	}
	public String getArchivo() {
		return this.archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	/// 
	///
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObservacionesImagenPK)) {
			return false;
		}
		ObservacionesImagenPK castOther = (ObservacionesImagenPK)other;
		return 
			(this.idObservacion == castOther.idObservacion)
			&& this.archivo.equals(castOther.archivo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idObservacion ^ (this.idObservacion >>> 32)));
		hash = hash * prime + this.archivo.hashCode();
		
		return hash;
	}
}