package enums;

public enum TiposUsuario {
	ADMINISTRADOR(1, "ADMINISTRADOR"),
	OBSERVADOR(2, "OBSERVADOR");
	// TODO: Agregar los demas tipos
	
	private int codigo;
	private String nombre;
	
	private TiposUsuario(int codigo, String nombre) {
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
