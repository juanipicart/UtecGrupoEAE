package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
@Table (name = "Roles")

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Rol() {
		super();
	}
   
	@Id
	@GeneratedValue
	private Long id_rol;
}
