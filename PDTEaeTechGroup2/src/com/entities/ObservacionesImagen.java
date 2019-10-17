package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OBSERVACIONES_IMAGENES database table.
 * 
 */
@Entity
@Table(name="OBSERVACIONES_IMAGENES")
@NamedQuery(name="ObservacionesImagen.findAll", query="SELECT o FROM ObservacionesImagen o")
public class ObservacionesImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesImagenPK id;

	@Lob
	private byte[] imagen;

	//bi-directional many-to-one association to Observacion
	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacione;

	public ObservacionesImagen() {
	}

	public ObservacionesImagenPK getId() {
		return this.id;
	}

	public void setId(ObservacionesImagenPK id) {
		this.id = id;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Observacion getObservacione() {
		return this.observacione;
	}

	public void setObservacione(Observacion observacione) {
		this.observacione = observacione;
	}

}