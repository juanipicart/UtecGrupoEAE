package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CARACTERISTICAS database table.
 * 
 */
@Entity
@Table(name="CARACTERISTICAS")
@NamedQuery(name="Caracteristica.findAll", query="SELECT c FROM Caracteristica c")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARACTERISTICAS_IDCARACTERISTICA_GENERATOR", sequenceName="ID_CARACT_CARACT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARACTERISTICAS_IDCARACTERISTICA_GENERATOR")
	@Column(name="ID_CARACTERISTICA")
	private long idCaracteristica;

	private String descripcion;

	private String etiqueta;

	private String nombre;

	private String tipo;

	//uni-directional many-to-many association to Fenomeno
	@ManyToMany
	@JoinTable(
		name="FENOMENOS_CARACTERISTICAS"
		, joinColumns={
			@JoinColumn(name="ID_CARACTERISTICA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_FENOMENO")
			}
		)
	private List<Fenomeno> fenomenos;

	public Caracteristica() {
	}

	public long getIdCaracteristica() {
		return this.idCaracteristica;
	}

	public void setIdCaracteristica(long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Fenomeno> getFenomenos() {
		return this.fenomenos;
	}

	public void setFenomenos(List<Fenomeno> fenomenos) {
		this.fenomenos = fenomenos;
	}

}