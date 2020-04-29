package com.clases.codigueras;

import java.io.Serializable;
import java.util.Date;

public class CodRol implements Serializable{

	private long id_rol;
	private String descripcion_rol; //max 20 not null
	private int estado; //not null
	Date fecha_desde; //not null
	private long id_estado; //not null
	
	
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}

	public long getId_rol() {
		return id_rol;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public String getDescripcion_rol() {
		return descripcion_rol;
	}

	public void setDescripcion_rol(String descripcion_rol) {
		this.descripcion_rol = descripcion_rol;
	}

	public int getId_estado() {
		return estado;
	}

	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}

	public Date getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}

	
	
	public CodRol(long id_rol, String descripcion_rol, int id_estado, Date fecha_desde) {
		super();
		this.id_rol = id_rol;
		this.descripcion_rol = descripcion_rol;
		this.estado = id_estado;
		this.fecha_desde = fecha_desde;
	}
	
	public CodRol(long id_rol, String descripcion_rol, long id_estado, Date fecha_desde) {
		super();
		this.id_rol = id_rol;
		this.descripcion_rol = descripcion_rol;
		this.id_estado = id_estado;
		this.fecha_desde = fecha_desde;
	}

	public CodRol() {
		// TODO Auto-generated constructor stub
	}

	
}
