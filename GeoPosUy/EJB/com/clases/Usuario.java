package com.clases;

import java.io.Serializable;

import com.clases.relaciones.RelUbicacion;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id_user;
	String usuario; //max 15 not null
	String nombre; //max 30 not null
	String apellido; //max 30 not null
	String direccion; //max 60 not null
	String correo;
	String password;
	int estado;
	int tipodoc;
	String documento;
	private RelUbicacion ubicacion; //not null
	int id_ubicacion;
	int rol; //not null
	
	public int getId_ubicacion() {
		return id_ubicacion;
	}






	public void setId_ubicacion(int id_ubicacion) {
		this.id_ubicacion = id_ubicacion;
	}




	
	
	public long getId_user() {
		return id_user;
	}






	public void setId_user(long id_user) {
		this.id_user = id_user;
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






	public String getCorreo() {
		return correo;
	}






	public void setCorreo(String correo) {
		this.correo = correo;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public int getEstado() {
		return estado;
	}






	public void setEstado(int estado) {
		this.estado = estado;
	}






	public int getTipodoc() {
		return tipodoc;
	}






	public void setTipodoc(int tipodoc) {
		this.tipodoc = tipodoc;
	}






	public String getDocumento() {
		return documento;
	}






	public void setDocumento(String documento) {
		this.documento = documento;
	}






	public RelUbicacion getUbicacion() {
		return ubicacion;
	}






	public void setUbicacion(RelUbicacion ubicacion) {
		this.ubicacion = ubicacion;
	}






	public int getRol() {
		return rol;
	}






	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public Usuario(Long id, String usuario, String nombre, String apellido, String direccion, String password, String documento,
			int estado, int rol, int tipodoc, String correo, RelUbicacion ubicacion) {
		super();
		this.id_user = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.password = password;
		this.documento = documento;
		this.estado = estado;
		this.rol = rol;
		this.tipodoc = tipodoc;
		this.correo = correo;
		this.ubicacion = ubicacion;
	}






	public Usuario(Long id_user2, String usuario2, String nombre2, String apellido2, String direccion2,
			String password2, String documento2, int estado2, int id_rol, int tipo_doc, String correo2,
			int id_ubicacion) {
		super();
		this.id_user = id_user2;
		this.usuario = usuario2;
		this.nombre = nombre2;
		this.apellido = apellido2;
		this.direccion = direccion2;
		this.password = password2;
		this.documento = documento2;
		this.estado = estado2;
		this.rol = id_rol;
		this.tipodoc = tipo_doc;
		this.correo = correo2;
		this.id_ubicacion = id_ubicacion;
	}



	public Usuario() {
		// TODO Auto-generated constructor stub
	}




}
