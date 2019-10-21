package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCALIDADES database table.
 * 
 */
@Entity
@Table(name="LOCALIDADES")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALIDADES_IDLOCALIDAD_GENERATOR", sequenceName="ID_LOCALIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALIDADES_IDLOCALIDAD_GENERATOR")
	@Column(name="ID_LOCALIDAD")
	private long idLocalidad;

	private String localidad;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="localidade")
	private List<Ubicacion> ubicaciones;

	public Localidad() {
	}

	public long getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Ubicacion> getUbicaciones() {
		return this.ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicacion addUbicacione(Ubicacion ubicacione) {
		getUbicaciones().add(ubicacione);
		ubicacione.setLocalidade(this);

		return ubicacione;
	}

	public Ubicacion removeUbicacione(Ubicacion ubicacione) {
		getUbicaciones().remove(ubicacione);
		ubicacione.setLocalidade(null);

		return ubicacione;
	}

}