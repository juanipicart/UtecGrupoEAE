package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS_TIPOS_DOC database table.
 * 
 */
@Entity
@Table(name="USUARIOS_TIPOS_DOC")
@NamedQuery(name="UsuariosTiposDoc.findAll", query="SELECT u FROM UsuariosTiposDoc u")
public class UsuariosTiposDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIOS_TIPOS_DOC_IDTIPODOC_GENERATOR", sequenceName="ID_TIPO_DOC_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIOS_TIPOS_DOC_IDTIPODOC_GENERATOR")
	@Column(name="ID_TIPO_DOC")
	private long idTipoDoc;

	private String tipo;

	//bi-directional many-to-one association to UsuariosDocumento
	@OneToMany(mappedBy="usuariosTiposDoc")
	private List<UsuariosDocumento> usuariosDocumentos;

	public UsuariosTiposDoc() {
	}

	public long getIdTipoDoc() {
		return this.idTipoDoc;
	}

	public void setIdTipoDoc(long idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<UsuariosDocumento> getUsuariosDocumentos() {
		return this.usuariosDocumentos;
	}

	public void setUsuariosDocumentos(List<UsuariosDocumento> usuariosDocumentos) {
		this.usuariosDocumentos = usuariosDocumentos;
	}

	public UsuariosDocumento addUsuariosDocumento(UsuariosDocumento usuariosDocumento) {
		getUsuariosDocumentos().add(usuariosDocumento);
		usuariosDocumento.setUsuariosTiposDoc(this);

		return usuariosDocumento;
	}

	public UsuariosDocumento removeUsuariosDocumento(UsuariosDocumento usuariosDocumento) {
		getUsuariosDocumentos().remove(usuariosDocumento);
		usuariosDocumento.setUsuariosTiposDoc(null);

		return usuariosDocumento;
	}

}