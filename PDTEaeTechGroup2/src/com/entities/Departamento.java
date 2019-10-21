package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DEPARTAMENTOS")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTOS_ID_SEQ", sequenceName="ID_DEPARTAMENTO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTOS_ID_SEQ")
	@Column(name="ID_DEPARTAMENTO")
	private String idDepartamento;

	private String departamento;

	@OneToMany(mappedBy="departamento")
	private List<Ubicacion> ubicaciones;

	public Departamento() {
	}

	public String getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Ubicacion> getUbicaciones() {
		return this.ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public Ubicacion addUbicacion(Ubicacion ubicacione) {
		getUbicaciones().add(ubicacione);
		ubicacione.setDepartamento(this);

		return ubicacione;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacione) {
		getUbicaciones().remove(ubicacione);
		ubicacione.setDepartamento(null);

		return ubicacione;
	}

}