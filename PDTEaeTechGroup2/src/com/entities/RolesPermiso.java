package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ROLES_PERMISOS")
@NamedQuery(name="RolesPermiso.findAll", query="SELECT r FROM RolesPermiso r")
public class RolesPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolesPermisoPK id;

	private String permiso;

	@ManyToOne
	@JoinColumn(name="ID_MODULO")
	private Modulo modulo;

	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private RolesUsuario rolesUsuario;

	public RolesPermiso() {
	}

	public RolesPermisoPK getId() {
		return this.id;
	}

	public void setId(RolesPermisoPK id) {
		this.id = id;
	}

	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public RolesUsuario getRolesUsuario() {
		return this.rolesUsuario;
	}

	public void setRolesUsuario(RolesUsuario rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

}