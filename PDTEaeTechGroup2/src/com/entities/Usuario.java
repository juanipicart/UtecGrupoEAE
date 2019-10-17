package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_IDUSER_GENERATOR", sequenceName="ID_USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_IDUSER_GENERATOR")
	@Column(name="ID_USER")
	private long idUser;

	private String apellido;

	private String direccion;

	@Column(name="ID_ROL")
	private java.math.BigDecimal idRol;

	@Column(name="ID_UBICACION")
	private java.math.BigDecimal idUbicacion;

	private String nombre;

	private String usuario;

	//bi-directional many-to-one association to UsuariosContacto
	@OneToMany(mappedBy="usuario")
	private List<UsuariosContacto> usuariosContactos;

	//bi-directional many-to-one association to UsuariosDocumento
	@OneToMany(mappedBy="usuario")
	private List<UsuariosDocumento> usuariosDocumentos;

	//bi-directional many-to-one association to UsuariosEstado
	@OneToMany(mappedBy="usuario")
	private List<UsuariosEstado> usuariosEstados;

	//bi-directional many-to-one association to UsuariosPasswd
	@OneToMany(mappedBy="usuario")
	private List<UsuariosPasswd> usuariosPasswds;

	public Usuario() {
	}

	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public java.math.BigDecimal getIdRol() {
		return this.idRol;
	}

	public void setIdRol(java.math.BigDecimal idRol) {
		this.idRol = idRol;
	}

	public java.math.BigDecimal getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(java.math.BigDecimal idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<UsuariosContacto> getUsuariosContactos() {
		return this.usuariosContactos;
	}

	public void setUsuariosContactos(List<UsuariosContacto> usuariosContactos) {
		this.usuariosContactos = usuariosContactos;
	}

	public UsuariosContacto addUsuariosContacto(UsuariosContacto usuariosContacto) {
		getUsuariosContactos().add(usuariosContacto);
		usuariosContacto.setUsuario(this);

		return usuariosContacto;
	}

	public UsuariosContacto removeUsuariosContacto(UsuariosContacto usuariosContacto) {
		getUsuariosContactos().remove(usuariosContacto);
		usuariosContacto.setUsuario(null);

		return usuariosContacto;
	}

	public List<UsuariosDocumento> getUsuariosDocumentos() {
		return this.usuariosDocumentos;
	}

	public void setUsuariosDocumentos(List<UsuariosDocumento> usuariosDocumentos) {
		this.usuariosDocumentos = usuariosDocumentos;
	}

	public UsuariosDocumento addUsuariosDocumento(UsuariosDocumento usuariosDocumento) {
		getUsuariosDocumentos().add(usuariosDocumento);
		usuariosDocumento.setUsuario(this);

		return usuariosDocumento;
	}

	public UsuariosDocumento removeUsuariosDocumento(UsuariosDocumento usuariosDocumento) {
		getUsuariosDocumentos().remove(usuariosDocumento);
		usuariosDocumento.setUsuario(null);

		return usuariosDocumento;
	}

	public List<UsuariosEstado> getUsuariosEstados() {
		return this.usuariosEstados;
	}

	public void setUsuariosEstados(List<UsuariosEstado> usuariosEstados) {
		this.usuariosEstados = usuariosEstados;
	}

	public UsuariosEstado addUsuariosEstado(UsuariosEstado usuariosEstado) {
		getUsuariosEstados().add(usuariosEstado);
		usuariosEstado.setUsuario(this);

		return usuariosEstado;
	}

	public UsuariosEstado removeUsuariosEstado(UsuariosEstado usuariosEstado) {
		getUsuariosEstados().remove(usuariosEstado);
		usuariosEstado.setUsuario(null);

		return usuariosEstado;
	}

	public List<UsuariosPasswd> getUsuariosPasswds() {
		return this.usuariosPasswds;
	}

	public void setUsuariosPasswds(List<UsuariosPasswd> usuariosPasswds) {
		this.usuariosPasswds = usuariosPasswds;
	}

	public UsuariosPasswd addUsuariosPasswd(UsuariosPasswd usuariosPasswd) {
		getUsuariosPasswds().add(usuariosPasswd);
		usuariosPasswd.setUsuario(this);

		return usuariosPasswd;
	}

	public UsuariosPasswd removeUsuariosPasswd(UsuariosPasswd usuariosPasswd) {
		getUsuariosPasswds().remove(usuariosPasswd);
		usuariosPasswd.setUsuario(null);

		return usuariosPasswd;
	}

}