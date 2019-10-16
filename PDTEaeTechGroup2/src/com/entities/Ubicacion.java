package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ubicación
 *
 */
@Entity
@Table(name="UBICACIONES")

public class Ubicacion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Ubicacion() {
	}
	
	@Id
	@SequenceGenerator(name = "idubic", sequenceName = "ID_UBICACION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idubic")
	@Column(name = "ID_UBICACION")
	private int id_ubicacion;
	
	@ManyToOne
	@Column(name = "ID_DEPARTAMENTO")
	private Departamento departamento;
	
	@ManyToOne
	@Column(name = "ID_LOCALIDAD")
	private Localidad localidad;
	
	@ManyToOne
	@Column(name = "ID_ZONA")
	private Zona zona;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Ubicacion(Departamento departamento, Localidad localidad, Zona zona) {
		super();
		this.departamento = departamento;
		this.localidad = localidad;
		this.zona = zona;
	}
	
	
   
}
