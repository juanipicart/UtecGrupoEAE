package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PALABRAS_PROHIBIDAS database table.
 * 
 */
@Entity
@Table(name="PALABRAS_PROHIBIDAS")
@NamedQuery(name="PalabrasProhibida.findAll", query="SELECT p FROM PalabrasProhibida p")
public class PalabrasProhibida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String palabra;

	private String detalle;

	public PalabrasProhibida() {
	}

	public String getPalabra() {
		return this.palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}