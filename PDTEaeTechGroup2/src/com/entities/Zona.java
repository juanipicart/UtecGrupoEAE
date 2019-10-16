package com.entities;

import java.io.Serializable;
import java.lang.Number;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Zonas
 *
 */
@Entity
@Table(name ="ZONAS")

public class Zona implements Serializable {

	// Se indica la secuencia, valor de crecimiento y un identificador
	@Id
	@SequenceGenerator(name = "idzona", sequenceName = "id_zona_seq", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "idzona")
	@Column(name = "ID_ZONA")
	private Number id_zona;
	
	@Column(name = "DESCRIPCION")
	private String Descripcion;
	
	private static final long serialVersionUID = 1L;

	public Zona() {
		super();
	}   
	public Number getId_zona() {
		return this.id_zona;
	}

	public void setId_zona(Number id_zona) {
		this.id_zona = id_zona;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
   
}
