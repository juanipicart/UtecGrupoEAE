package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIOS_CONTACTOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS_CONTACTOS")
@NamedQuery(name="UsuariosContacto.findAll", query="SELECT u FROM UsuariosContacto u")
public class UsuariosContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosContactoPK id;

	private String contacto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to UsuariosTiposContacto
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private UsuariosTiposContacto usuariosTiposContacto;

	public UsuariosContacto() {
	}

	public UsuariosContactoPK getId() {
		return this.id;
	}

	public void setId(UsuariosContactoPK id) {
		this.id = id;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuariosTiposContacto getUsuariosTiposContacto() {
		return this.usuariosTiposContacto;
	}

	public void setUsuariosTiposContacto(UsuariosTiposContacto usuariosTiposContacto) {
		this.usuariosTiposContacto = usuariosTiposContacto;
	}

}