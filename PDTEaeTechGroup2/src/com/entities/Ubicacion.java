package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UBICACIONES database table.
 * 
 */
@Entity
@Table(name="UBICACIONES")
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONES_IDUBICACION_GENERATOR", sequenceName="ID_UBICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONES_IDUBICACION_GENERATOR")
	@Column(name="ID_UBICACION")
	private long idUbicacion;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD")
	private Localidad localidade;

	//bi-directional many-to-one association to Zona
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
		return this.localidade;
	}

	public void setLocalidade(Localidad localidade) {
		this.localidade = localidade;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}