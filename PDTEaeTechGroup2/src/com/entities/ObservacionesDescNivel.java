package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OBSERVACIONES_DESC_NIVEL")
@NamedQuery(name="ObservacionesDescNivel.findAll", query="SELECT o FROM ObservacionesDescNivel o")
public class ObservacionesDescNivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBS_DESC_NIVEL_ID", sequenceName="ID_NIVEL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBS_DESC_NIVEL_ID")
	@Column(name="ID_NIVEL")
	private long idNivel;

	private String descripcion;

	@Column(name="DESCRIPCION_CORTA")
	private String descripcionCorta;

	@OneToMany(mappedBy="observacionesDescNivel")
	private List<ObservacionesCriticidad> observacionesCriticidad;

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

	public List<ObservacionesCriticidad> getObservacionesCriticidad() {
		return this.observacionesCriticidad;
	}

	public void setObservacionesCriticidad(List<ObservacionesCriticidad> observacionesCriticidads) {
		this.observacionesCriticidad = observacionesCriticidads;
	}

	public ObservacionesCriticidad addObservacionesCriticidad(ObservacionesCriticidad observacionesCriticidad) {
		getObservacionesCriticidad().add(observacionesCriticidad);
		observacionesCriticidad.setObservacionesDescNivel(this);

		return observacionesCriticidad;
	}

	public ObservacionesCriticidad removeObservacionesCriticidad(ObservacionesCriticidad observacionesCriticidad) {
		getObservacionesCriticidad().remove(observacionesCriticidad);
		observacionesCriticidad.setObservacionesDescNivel(null);

		return observacionesCriticidad;
	}

}