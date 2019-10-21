package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USUARIOS_DESC_ESTADOS")
@NamedQuery(name="UsuariosDescEstado.findAll", query="SELECT u FROM UsuariosDescEstado u")

public class UsuariosDescEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_DE_ID", sequenceName="ID_ESTADO_USUARIO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_DE_ID")
	@Column(name="ID_ESTADO")
	private long idEstado;

	@Column(name="DESC_ESTADO")
	private String descEstado;

	@OneToMany(mappedBy="usuariosDescEstado")
	private List<RolesUsuario> rolesUsuarios;

	
	public UsuariosDescEstado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescEstado() {
		return this.descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setUsuariosDescEstado(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setUsuariosDescEstado(null);

		return rolesUsuario;
	}

}