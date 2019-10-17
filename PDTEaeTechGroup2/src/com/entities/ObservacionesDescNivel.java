package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OBSERVACIONES_DESC_NIVEL database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES_DESC_NIVEL")
@NamedQuery(name="ObservacionesDescNivel.findAll", query="SELECT o FROM ObservacionesDescNivel o")
public class ObservacionesDescNivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBSERVACIONES_DESC_NIVEL_IDNIVEL_GENERATOR", sequenceName="ID_NIVEL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBSERVACIONES_DESC_NIVEL_IDNIVEL_GENERATOR")
	@Column(name="ID_NIVEL")
	private long idNivel;

	private String descripcion;

	@Column(name="DESCRIPCION_CORTA")
	private String descripcionCorta;

	//bi-directional many-to-one association to ObservacionesCriticidad
	@OneToMany(mappedBy="observacionesDescNivel")
	private List<ObservacionesCriticidad> observacionesCriticidads;

	public ObservacionesDescNivel() {
	}

	public long getIdNivel() {
		return this.idNivel;
	}

	public void setIdNivel(long idNivel) {
		this.idNivel = idNivel;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public List<ObservacionesCriticidad> getObservacionesCriticidads() {
		return this.observacionesCriticidads;
	}

	public void setObservacionesCriticidads(List<ObservacionesCriticidad> observacionesCriticidads) {
		this.observacionesCriticidads = observacionesCriticidads;
	}

	public ObservacionesCriticidad addObservacionesCriticidad(ObservacionesCriticidad observacionesCriticidad) {
		getObservacionesCriticidads().add(observacionesCriticidad);
		observacionesCriticidad.setObservacionesDescNivel(this);

		return observacionesCriticidad;
	}

	public ObservacionesCriticidad removeObservacionesCriticidad(ObservacionesCriticidad observacionesCriticidad) {
		getObservacionesCriticidads().remove(observacionesCriticidad);
		observacionesCriticidad.setObservacionesDescNivel(null);

		return observacionesCriticidad;
	}

}