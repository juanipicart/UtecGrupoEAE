package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ROLES_USUARIOS database table.
 * 
 */
@Entity
@Table(name="ROLES_USUARIOS")
@NamedQuery(name="RolesUsuario.findAll", query="SELECT r FROM RolesUsuario r")
public class RolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ROL")
	private long idRol;

	@Column(name="DESCRIPCION_ROL")
	private String descripcionRol;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	//bi-directional many-to-one association to UsuariosDescEstado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private UsuariosDescEstado usuariosDescEstado;

	public RolesUsuario() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionRol() {
		return this.descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public UsuariosDescEstado getUsuariosDescEstado() {
		return this.usuariosDescEstado;
	}

	public void setUsuariosDescEstado(UsuariosDescEstado usuariosDescEstado) {
		this.usuariosDescEstado = usuariosDescEstado;
	}

}