package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OBSERVACIONES_DESC_ESTADOS")
@NamedQuery(name="ObservacionesDescEstado.findAll", query="SELECT o FROM ObservacionesDescEstado o")
public class ObservacionesDescEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBS_D_E_ID", sequenceName="ID_ESTADO_OBS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBS_D_E_ID")
	@Column(name="ID_ESTADO")
	private long idEstado;

	private String descripcion;

	@OneToMany(mappedBy="observacionesDescEstado")
	private List<ObservacionesEstado> observacionesEstados;

	public ObservacionesDescEstado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ObservacionesEstado> getObservacionesEstados() {
		return this.observacionesEstados;
	}

	public void setObservacionesEstados(List<ObservacionesEstado> observacionesEstados) {
		this.observacionesEstados = observacionesEstados;
	}

	public ObservacionesEstado addObservacionesEstado(ObservacionesEstado observacionesEstado) {
		getObservacionesEstados().add(observacionesEstado);
		observacionesEstado.setObservacionesDescEstado(this);

		return observacionesEstado;
	}

	public ObservacionesEstado removeObservacionesEstado(ObservacionesEstado observacionesEstado) {
		getObservacionesEstados().remove(observacionesEstado);
		observacionesEstado.setObservacionesDescEstado(null);

		return observacionesEstado;
	}

}