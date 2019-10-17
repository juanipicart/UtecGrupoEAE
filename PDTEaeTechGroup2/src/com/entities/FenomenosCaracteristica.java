package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FENOMENOS_CARACTERISTICAS database table.
 * 
 */
@Entity
@Table(name="FENOMENOS_CARACTERISTICAS")
@NamedQuery(name="FenomenosCaracteristica.findAll", query="SELECT f FROM FenomenosCaracteristica f")
public class FenomenosCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FenomenosCaracteristicaPK id;

	//bi-directional many-to-one association to ObservacionesFenomeno
	@OneToMany(mappedBy="fenomenosCaracteristica")
	private List<ObservacionesFenomeno> observacionesFenomenos;

	public FenomenosCaracteristica() {
	}

	public FenomenosCaracteristicaPK getId() {
		return this.id;
	}

	public void setId(FenomenosCaracteristicaPK id) {
		this.id = id;
	}

	public List<ObservacionesFenomeno> getObservacionesFenomenos() {
		return this.observacionesFenomenos;
	}

	public void setObservacionesFenomenos(List<ObservacionesFenomeno> observacionesFenomenos) {
		this.observacionesFenomenos = observacionesFenomenos;
	}

	public ObservacionesFenomeno addObservacionesFenomeno(ObservacionesFenomeno observacionesFenomeno) {
		getObservacionesFenomenos().add(observacionesFenomeno);
		observacionesFenomeno.setFenomenosCaracteristica(this);

		return observacionesFenomeno;
	}

	public ObservacionesFenomeno removeObservacionesFenomeno(ObservacionesFenomeno observacionesFenomeno) {
		getObservacionesFenomenos().remove(observacionesFenomeno);
		observacionesFenomeno.setFenomenosCaracteristica(null);

		return observacionesFenomeno;
	}

}