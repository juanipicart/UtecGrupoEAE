package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name= "USUARIOS")

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID_USER")
	private Long id;
	
	//Nombre de Usuario
	@Column(name = "USUARIO")
	private String usuario; 
	
	//Nombre de la persona
	@Column(name = "NOMBRE")
	private String nombre;
	
	//Apellido de la persona
	@Column(name = "APELLIDO")
	private String apellido;
	
	//Dirección de la persona
	@Column(name = "DIRECCION")
	private String direccion;
	
	//Ubicación de la persona
	@OneToOne
	@Column(name = "ID_UBICACION")
	private Ubicacion ubicacion;
	
	//Rol de la persona
	@OneToOne
	@Column(name = "ID_ROL")
	private Rol rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
}
