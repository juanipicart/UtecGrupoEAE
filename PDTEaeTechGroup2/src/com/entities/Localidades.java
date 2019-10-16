package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCALIDADES database table.
 * 
 */
@Entity
@NamedQuery(name="Localidades.findAll", query="SELECT l FROM Localidades l")
public class Localidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALIDADES_IDLOCALIDAD_GENERATOR", sequenceName="ID_LOCALIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALIDADES_IDLOCALIDAD_GENERATOR")
	@Column(name="ID_LOCALIDAD")
	private long idLocalidad;

	private String localidad;

	//bi-directional many-to-one association to Ubicaciones
	@OneToMany(mappedBy="localidade")
	private List<Ubicaciones> ubicaciones;

	public Localidades() {
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

	public List<Ubicaciones> getUbicaciones() {
		return this.ubicaciones;
	}

	public void setUbicaciones(List<Ubicaciones> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicaciones addUbicacione(Ubicaciones ubicacione) {
		getUbicaciones().add(ubicacione);
		ubicacione.setLocalidade(this);

		return ubicacione;
	}

	public Ubicaciones removeUbicacione(Ubicaciones ubicacione) {
		getUbicaciones().remove(ubicacione);
		ubicacione.setLocalidade(null);

		return ubicacione;
	}

}