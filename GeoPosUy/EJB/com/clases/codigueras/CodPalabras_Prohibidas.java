package com.clases.codigueras;

public class CodPalabras_Prohibidas {
	

	String palabra; //max 20 not null
	String detalle; //max 40
	
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	
	public CodPalabras_Prohibidas(String palabra, String detalle) {
		super();
		this.palabra = palabra;
		this.detalle = detalle;
	}
	
	public CodPalabras_Prohibidas(String palabra) {
		super();
		this.palabra = palabra;
	}
}
