package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OBSERVACIONES_ESTADOS")
@NamedQuery(name="ObservacionesEstado.findAll", query="SELECT o FROM ObservacionesEstado o")
public class ObservacionesEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesEstadoPK id;

	////   
	// https://www.baeldung.com/hibernate-date-time
	////
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacion;

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

	public Observacion getObservacion() {
		return this.observacion;
	}

	public void setObservacion(Observacion observacione) {
		this.observacion = observacione;
	}

	public ObservacionesDescEstado getObservacionesDescEstado() {
		return this.observacionesDescEstado;
	}

	public void setObservacionesDescEstado(ObservacionesDescEstado observacionesDescEstado) {
		this.observacionesDescEstado = observacionesDescEstado;
	}

}