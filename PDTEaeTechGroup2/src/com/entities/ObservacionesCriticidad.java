package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OBSERVACIONES_CRITICIDAD")
@NamedQuery(name="ObservacionesCriticidad.findAll", query="SELECT o FROM ObservacionesCriticidad o")
public class ObservacionesCriticidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesCriticidadPK id;

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
	@JoinColumn(name="ID_NIVEL")
	private ObservacionesDescNivel observacionesDescNivel;

	public ObservacionesCriticidad() {
	}

	public ObservacionesCriticidadPK getId() {
		return this.id;
	}

	public void setId(ObservacionesCriticidadPK id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Observacion getObservacione() {
		return this.observacion;
	}

	public void setObservacione(Observacion observacion) {
		this.observacion = observacion;
	}

	public ObservacionesDescNivel getObservacionesDescNivel() {
		return this.observacionesDescNivel;
	}

	public void setObservacionesDescNivel(ObservacionesDescNivel observacionesDescNivel) {
		this.observacionesDescNivel = observacionesDescNivel;
	}

}