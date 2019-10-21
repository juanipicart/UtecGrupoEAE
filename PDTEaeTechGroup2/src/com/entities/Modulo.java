package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MODULOS")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODULOS_ID_SEQ", sequenceName="ID_MODULO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODULOS_ID_SEQ")
	@Column(name="ID_MODULO")
	private long idModulo;

	private String descripcion;

	@OneToMany(mappedBy="modulo")
	private List<RolesPermiso> rolesPermisos;

	public Modulo() {
	}

	public long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(long idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<RolesPermiso> getRolesPermisos() {
		return this.rolesPermisos;
	}

	public void setRolesPermisos(List<RolesPermiso> rolesPermisos) {
		this.rolesPermisos = rolesPermisos;
	}

	public RolesPermiso addRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().add(rolesPermiso);
		rolesPermiso.setModulo(this);

		return rolesPermiso;
	}

	public RolesPermiso removeRolesPermiso(RolesPermiso rolesPermiso) {
		getRolesPermisos().remove(rolesPermiso);
		rolesPermiso.setModulo(null);

		return rolesPermiso;
	}

}