package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ubicación
 *
 */
@Entity
@Table(name="Ubicaciones")

public class Ubicacion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Ubicacion() {
		super();
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID_UBICACION")
	private Long id_ubicacion;
   
}
