package com.clases.relaciones;

import java.util.Date;

import com.clases.codigueras.CodEstado;

public class Rel_Obs_Estado {	

	private long id_observacion;
	private CodEstado estado; //not null
	private Date fecha_desde; //not null

	
	public long getId_observacion() {
		return id_observacion;
	}
	public void setId_observacion(long id_observacion) {
		this.id_observacion = id_observacion;
	}
	public CodEstado getId_estado() {
		return estado;
	}
	public void setId_estado(CodEstado id_estado) {
		this.estado = id_estado;
	}
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	
	public Rel_Obs_Estado(long id_observacion, CodEstado estado, Date fecha_desde) {
		super();
		this.id_observacion = id_observacion;
		this.estado = estado;
		this.fecha_desde = fecha_desde;
	}
	
}
