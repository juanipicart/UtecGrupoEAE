package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="FENOMENOS")
@NamedQuery(name="Fenomeno.findAll", query="SELECT f FROM Fenomeno f")
public class Fenomeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FENOMENOS_ID_SEQ", sequenceName="ID_FENOMENO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FENOMENOS_ID_SEQ")
	@Column(name="ID_FENOMENO")
	private long idFenomeno;

	@Column(name="CONTACTO_EMERGENCIA")
	private String contactoEmergencia;

	private String descripcion;

	private String nombre;

	public Fenomeno() {
	}

	public long getIdFenomeno() {
		return this.idFenomeno;
	}

	public void setIdFenomeno(long idFenomeno) {
		this.idFenomeno = idFenomeno;
	}

	public String getContactoEmergencia() {
		return this.contactoEmergencia;
	}

	public void setContactoEmergencia(String contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}