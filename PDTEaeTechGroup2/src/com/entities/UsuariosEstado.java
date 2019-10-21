package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="USUARIOS_ESTADOS")
@NamedQuery(name="UsuariosEstado.findAll", query="SELECT u FROM UsuariosEstado u")
public class UsuariosEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosEstadoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private UsuariosDescEstado usuariosDescEstado;

	public UsuariosEstado() {
	}

	public UsuariosEstadoPK getId() {
		return this.id;
	}

	public void setId(UsuariosEstadoPK id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuariosDescEstado getUsuariosDescEstado() {
		return this.usuariosDescEstado;
	}

	public void setUsuariosDescEstado(UsuariosDescEstado usuariosDescEstado) {
		this.usuariosDescEstado = usuariosDescEstado;
	}

}