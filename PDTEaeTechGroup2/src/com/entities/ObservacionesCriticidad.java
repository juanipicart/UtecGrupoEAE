package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OBSERVACIONES_CRITICIDAD database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES_CRITICIDAD")
@NamedQuery(name="ObservacionesCriticidad.findAll", query="SELECT o FROM ObservacionesCriticidad o")
public class ObservacionesCriticidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesCriticidadPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	//bi-directional many-to-one association to Observacion
	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacione;

	//bi-directional many-to-one association to ObservacionesDescNivel
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
		return this.observacione;
	}

	public void setObservacione(Observacion observacione) {
		this.observacione = observacione;
	}

	public ObservacionesDescNivel getObservacionesDescNivel() {
		return this.observacionesDescNivel;
	}

	public void setObservacionesDescNivel(ObservacionesDescNivel observacionesDescNivel) {
		this.observacionesDescNivel = observacionesDescNivel;
	}

}