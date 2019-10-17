package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OBSERVACIONES_ESTADOS database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES_ESTADOS")
@NamedQuery(name="ObservacionesEstado.findAll", query="SELECT o FROM ObservacionesEstado o")
public class ObservacionesEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesEstadoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	//bi-directional many-to-one association to Observacion
	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacione;

	//bi-directional many-to-one association to ObservacionesDescEstado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private ObservacionesDescEstado observacionesDescEstado;

	public ObservacionesEstado() {
	}

	public ObservacionesEstadoPK getId() {
		return this.id;
	}

	public void setId(ObservacionesEstadoPK id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Observacion getObservacione() {
		return this.observacione;
	}

	public void setObservacione(Observacion observacione) {
		this.observacione = observacione;
	}

	public ObservacionesDescEstado getObservacionesDescEstado() {
		return this.observacionesDescEstado;
	}

	public void setObservacionesDescEstado(ObservacionesDescEstado observacionesDescEstado) {
		this.observacionesDescEstado = observacionesDescEstado;
	}

}