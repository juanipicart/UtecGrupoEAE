package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="UBICACIONES")
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONES_ID", sequenceName="ID_UBICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONES_ID")
	@Column(name="ID_UBICACION")
	private long idUbicacion;

	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD")
	private Localidad localidad;

	@ManyToOne
	@JoinColumn(name="ID_ZONA")
	private Zona zona;

	public Ubicacion() {
	}

	public long getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Localidad getLocalidade() {
		return this.localidad;
	}

	public void setLocalidade(Localidad localidad) {
		this.localidad = localidad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}