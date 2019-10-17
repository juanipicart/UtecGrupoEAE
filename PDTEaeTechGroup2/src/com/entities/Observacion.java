package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the OBSERVACIONES database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES")
@NamedQuery(name="Observacion.findAll", query="SELECT o FROM Observacion o")
public class Observacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBSERVACIONES_IDOBSERVACION_GENERATOR", sequenceName="ID_OBSERVACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBSERVACIONES_IDOBSERVACION_GENERATOR")
	@Column(name="ID_OBSERVACION")
	private long idObservacion;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	private String geolocalizacion;

	@Column(name="ID_UBICACION")
	private java.math.BigDecimal idUbicacion;

	@Column(name="ID_USUARIO")
	private java.math.BigDecimal idUsuario;

	//bi-directional many-to-one association to ObservacionesEstado
	@OneToMany(mappedBy="observacione")
	private List<ObservacionesEstado> observacionesEstados;

	public Observacion() {
	}

	public long getIdObservacion() {
		return this.idObservacion;
	}

	public void setIdObservacion(long idObservacion) {
		this.idObservacion = idObservacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getGeolocalizacion() {
		return this.geolocalizacion;
	}

	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public java.math.BigDecimal getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(java.math.BigDecimal idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public java.math.BigDecimal getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(java.math.BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<ObservacionesEstado> getObservacionesEstados() {
		return this.observacionesEstados;
	}

	public void setObservacionesEstados(List<ObservacionesEstado> observacionesEstados) {
		this.observacionesEstados = observacionesEstados;
	}

	public ObservacionesEstado addObservacionesEstado(ObservacionesEstado observacionesEstado) {
		getObservacionesEstados().add(observacionesEstado);
		observacionesEstado.setObservacione(this);

		return observacionesEstado;
	}

	public ObservacionesEstado removeObservacionesEstado(ObservacionesEstado observacionesEstado) {
		getObservacionesEstados().remove(observacionesEstado);
		observacionesEstado.setObservacione(null);

		return observacionesEstado;
	}

}