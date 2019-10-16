package com.entities;

import javax.persistence.*;

@Entity
@Table(name="LOCALIDADES")
public class Localidad {
	
	@Id
	@SequenceGenerator(name="ID_LOCAL",sequenceName= "ID_LOCALIDAD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ID_LOCAL")
	@Column(name="ID_LOCALIDAD")
	private Long id;
	
	@Column(name="LOCALIDAD")
	private String nombre_localidad;
	
	public String getNombre_localidad() {
		return nombre_localidad;
	}

	public void setNombre_localidad(String nombre_localidad) {
		this.nombre_localidad = nombre_localidad;
	}

	public Localidad() {
		super();
	}
	
	
	
	

	


}
