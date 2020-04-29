package enums;

public enum Estados {

	ACTIVO(1, "ACTIVO"),
	INACTIVO(2, "INACTIVO");
	// TODO: Agregar los demas tipos
	
	private int codigo;
	private String nombre;
	
	private Estados(int codigo, String nombre) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
