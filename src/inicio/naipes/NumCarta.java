package inicio.naipes;

public enum NumCarta {
	DOS("2", 2), TRES("3", 3), CUATRO("4", 4), CINCO("5", 5), SEIS("6", 6), SIETE("7", 7), OCHO("8", 8), NUEVE("9", 9),
	DIEZ("10", 10), J("J", 10), Q("Q", 10), K("K", 10), AS("AS", 11);

	private String nombre;
	private int valor;

	NumCarta(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
