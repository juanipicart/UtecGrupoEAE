package com.entities;

import javax.persistence.*;

@Entity
@Table(name="Zonas")
public class Zona {
	
	@Id
	@SequenceGenerator(name="id_zona",sequenceName = "ID_ZONA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_zona")
	private Long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Zona(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Zona() {
		super();
	}
	
	

}
