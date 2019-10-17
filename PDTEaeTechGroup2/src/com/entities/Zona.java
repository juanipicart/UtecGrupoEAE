package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ZONAS database table.
 * 
 */
@Entity
@Table(name="ZONAS")
@NamedQuery(name="Zona.findAll", query="SELECT z FROM Zona z")
public class Zona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ZONAS_IDZONA_GENERATOR", sequenceName="ID_ZONA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ZONAS_IDZONA_GENERATOR")
	@Column(name="ID_ZONA")
	private long idZona;

	private String descripcion;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="zona")
	private List<Ubicacion> ubicaciones;

	public Zona() {
	}

	public long getIdZona() {
		return this.idZona;
	}

	public void setIdZona(long idZona) {
		this.idZona = idZona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Ubicacion> getUbicaciones() {
		return this.ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicacion addUbicacione(Ubicacion ubicacione) {
		getUbicaciones().add(ubicacione);
		ubicacione.setZona(this);

		return ubicacione;
	}

	public Ubicacion removeUbicacione(Ubicacion ubicacione) {
		getUbicaciones().remove(ubicacione);
		ubicacione.setZona(null);

		return ubicacione;
	}

}