package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USUARIOS_TIPOS_CONTACTOS")
@NamedQuery(name="UsuariosTiposContacto.findAll", query="SELECT u FROM UsuariosTiposContacto u")
public class UsuariosTiposContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_TC_ID", sequenceName="ID_TIPO_CONTACTO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_TC_ID")
	@Column(name="ID_TIPO")
	private long idTipo;

	private String descripcion;

	@OneToMany(mappedBy="usuariosTiposContacto")
	private List<UsuariosContacto> usuariosContactos;

	public UsuariosTiposContacto() {
	}

	public long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuariosContacto> getUsuariosContactos() {
		return this.usuariosContactos;
	}

	public void setUsuariosContactos(List<UsuariosContacto> usuariosContactos) {
		this.usuariosContactos = usuariosContactos;
	}

	public UsuariosContacto addUsuariosContacto(UsuariosContacto usuariosContacto) {
		getUsuariosContactos().add(usuariosContacto);
		usuariosContacto.setUsuariosTiposContacto(this);

		return usuariosContacto;
	}

	public UsuariosContacto removeUsuariosContacto(UsuariosContacto usuariosContacto) {
		getUsuariosContactos().remove(usuariosContacto);
		usuariosContacto.setUsuariosTiposContacto(null);

		return usuariosContacto;
	}

}