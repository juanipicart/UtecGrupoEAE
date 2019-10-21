package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="USUARIOS_PASSWD")
@NamedQuery(name="UsuariosPasswd.findAll", query="SELECT u FROM UsuariosPasswd u")
public class UsuariosPasswd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosPasswdPK id;

	private String passwd;

	@ManyToOne
	@JoinColumn(name="ID_USER")
	private Usuario usuario;

	public UsuariosPasswd() {
	}

	public UsuariosPasswdPK getId() {
		return this.id;
	}

	public void setId(UsuariosPasswdPK id) {
		this.id = id;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}