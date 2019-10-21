package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="LOCALIDADES")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALIDADES_ID_SEQ", sequenceName="ID_LOCALIDAD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALIDADES_ID_SEQ")
	@Column(name="ID_LOCALIDAD")
	private long idLocalidad;

	private String localidad;

	@OneToMany(mappedBy="localidad")
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

	public Ubicacion addUbicacion(Ubicacion ubicacione) {
		getUbicaciones().add(ubicacione);
		ubicacione.setLocalidade(this);

		return ubicacione;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacione) {
		getUbicaciones().remove(ubicacione);
		ubicacione.setLocalidade(null);

		return ubicacione;
	}

}