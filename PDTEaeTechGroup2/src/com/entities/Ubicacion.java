package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UBICACIONES database table.
 * 
 */
@Entity
@Table(name = "UBICACIONES")
@NamedQuery(name="Ubicaciones.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACIONES_IDUBICACION_GENERATOR", sequenceName="ID_UBICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACIONES_IDUBICACION_GENERATOR")
	@Column(name="ID_UBICACION")
	private long idUbicacion;

	@Column(name="ID_ZONA")
	private java.math.BigDecimal idZona;

	//bi-directional many-to-one association to Departamentos
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;

	//bi-directional many-to-one association to Localidades
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD")
	private Localidades localidade;

	public Ubicacion() {
	}

	public long getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public java.math.BigDecimal getIdZona() {
		return this.idZona;
	}

	public void setIdZona(java.math.BigDecimal idZona) {
		this.idZona = idZona;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Localidades getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(Localidades localidade) {
		this.localidade = localidade;
	}

}