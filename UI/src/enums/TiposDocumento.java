package enums;

public enum TiposDocumento {

		CEDULA(1, "CEDULA"),
		PASAPORTE(2, "PASAPORTE");
		// TODO: Agregar los demas tipos
		
		private int codigo;
		private String nombre;
		
		private TiposDocumento(int codigo, String nombre) {
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
