package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USUARIOS_DOCUMENTOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS_DOCUMENTOS")
@NamedQuery(name="UsuariosDocumento.findAll", query="SELECT u FROM UsuariosDocumento u")
public class UsuariosDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosDocumentoPK id;

	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to UsuariosTiposDoc
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DOC")
	private UsuariosTiposDoc usuariosTiposDoc;

	public UsuariosDocumento() {
	}

	public UsuariosDocumentoPK getId() {
		return this.id;
	}

	public void setId(UsuariosDocumentoPK id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuariosTiposDoc getUsuariosTiposDoc() {
		return this.usuariosTiposDoc;
	}

	public void setUsuariosTiposDoc(UsuariosTiposDoc usuariosTiposDoc) {
		this.usuariosTiposDoc = usuariosTiposDoc;
	}

}