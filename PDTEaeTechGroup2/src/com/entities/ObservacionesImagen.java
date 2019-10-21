package com.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="OBSERVACIONES_IMAGENES")
@NamedQuery(name="ObservacionesImagen.findAll", query="SELECT o FROM ObservacionesImagen o")
public class ObservacionesImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObservacionesImagenPK id;

	// segun vi, es asi el BLOB
	@Lob
	private byte[] imagen;

	@ManyToOne
	@JoinColumn(name="ID_OBSERVACION")
	private Observacion observacion;

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

	public Observacion getObservacion() {
		return this.observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

}