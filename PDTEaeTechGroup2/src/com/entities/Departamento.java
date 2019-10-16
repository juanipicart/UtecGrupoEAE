package com.entities;

import javax.persistence.*;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento {
	
	@Id
	@SequenceGenerator(name="id_dep",sequenceName = "ID_DEPARTAMENTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_dep")
	@Column(name="ID_DEPARTAMENTO")
	private Long id;
	
	@Column(name="DEPARTAMENTO")
	private String departamento;

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Departamento(String departamento) {
		super();
		this.departamento = departamento;
	}

	public Departamento() {
	}
	
	
	

}
