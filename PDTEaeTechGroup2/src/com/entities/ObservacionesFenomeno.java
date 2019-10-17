package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OBSERVACIONES_FENOMENOS database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES_FENOMENOS")
@NamedQuery(name="ObservacionesFenomeno.findAll", query="SELECT o FROM ObservacionesFenomeno o")
public class ObservacionesFenomeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesFenomenoPK id;

	private String valor;

	//bi-directional many-to-one association to FenomenosCaracteristica
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_CARACTERISTICA", referencedColumnName="ID_CARACTERISTICA"),
		@JoinColumn(name="ID_FENOMENO", referencedColumnName="ID_FENOMENO")
		})
	private FenomenosCaracteristica fenomenosCaracteristica;

	//bi-directional many-to-one association to Observacion
	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacione;

	public ObservacionesFenomeno() {
	}

	public ObservacionesFenomenoPK getId() {
		return this.id;
	}

	public void setId(ObservacionesFenomenoPK id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public FenomenosCaracteristica getFenomenosCaracteristica() {
		return this.fenomenosCaracteristica;
	}

	public void setFenomenosCaracteristica(FenomenosCaracteristica fenomenosCaracteristica) {
		this.fenomenosCaracteristica = fenomenosCaracteristica;
	}

	public Observacion getObservacione() {
		return this.observacione;
	}

	public void setObservacione(Observacion observacione) {
		this.observacione = observacione;
	}

}