package inicio.teatro;

public class Butaca {

	private int posicion;
	private int fila;
	private int col;
	private boolean ocupado;

	// Para el polimorfismo
	protected float precio;

	private Butaca(int posicion, int fila, int col) {
		this.posicion = posicion;
		this.fila = fila;
		this.col = col;
		this.ocupado = false;
	}

	public Butaca(int posicion) {
		this.posicion = posicion;
		this.ocupado = false;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	// Para el polimorfismo
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.col = precio;
	}

	public static Butaca crear(int posicion, int fila, int col) {
		return new Butaca(posicion, fila, col);
	}

	public static void dibujarSala(int[] asiento, int cols, int filas) {

		System.out.println("|OUT|======== TARIMA ========|OUT|");
		System.out.println("|________________________________|");

		for (int j = 0; j < filas; j++) {
			System.out.print("| ");
			for (int i = 0; i < cols; i++) {
				if (asiento[(cols * j) + i] == 0) {
					System.out.print(" o ");
				} else {
					System.out.print(" x ");
				}
			}
			System.out.println(" |");
		}

		System.out.println("|                                |");
		System.out.println("|IN|__________________________|IN|");
		System.out.println();

	}

	public static int[] setUpArray(int dimension) {
		int vector[] = new int[dimension];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
		}
		return vector;
	}

}