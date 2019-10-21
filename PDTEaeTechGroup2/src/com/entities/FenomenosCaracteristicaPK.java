package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class FenomenosCaracteristicaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// NO INSERTA NI ACTUALIZA, SOLO LO USA PARA LEER DATOS
	@Column(name="ID_FENOMENO", insertable=false, updatable=false)
	private long idFenomeno;

	@Column(name="ID_CARACTERISTICA", insertable=false, updatable=false)
	private long idCaracteristica;

	public FenomenosCaracteristicaPK() {
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

	// EMBEDDABLE ME PIDE COLOCAR ESTOS METODOS, SI LOS SACO ME PUTEA
	// LOS SAQUE DE INTERNET
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FenomenosCaracteristicaPK)) {
			return false;
		}
		FenomenosCaracteristicaPK castOther = (FenomenosCaracteristicaPK)other;
		return 
			(this.idFenomeno == castOther.idFenomeno)
			&& (this.idCaracteristica == castOther.idCaracteristica);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFenomeno ^ (this.idFenomeno >>> 32)));
		hash = hash * prime + ((int) (this.idCaracteristica ^ (this.idCaracteristica >>> 32)));
		
		return hash;
	}
}