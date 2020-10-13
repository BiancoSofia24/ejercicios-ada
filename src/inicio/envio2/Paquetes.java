package inicio.envio2;

public class Paquetes {

	// Constantes
	// Precio por zona
	private static int PRECIO_Z1 = 5;
	private static int PRECIO_Z2 = 8;
	private static int PRECIO_Z3 = 10;

	// Variables globales
	private float carga;
	private int zona;
	private boolean transportable;

	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public boolean isTransportable() {
		return transportable;
	}

	public void setTransportable(boolean transportable) {
		this.transportable = transportable;
	}

	// Constructor
	public Paquetes(float peso) {
		this.carga = peso;
		this.transportable = false;
	}

	// Métodos
	public float calcularPrecio(float peso, int zona) {
		float precio = 0;

		switch (zona) {
		case 1:
			precio = PRECIO_Z1 * peso;
			break;
		case 2:
			precio = PRECIO_Z2 * peso;
			break;
		case 3:
			precio = PRECIO_Z3 * peso;
			break;
		}

		return precio;
	}

	public int conocerCosto(int zona) {
		int costo = 0;

		switch (zona) {
		case 1:
			costo = PRECIO_Z1;
			break;
		case 2:
			costo = PRECIO_Z2;
			break;
		case 3:
			costo = PRECIO_Z3;
			break;
		}

		return costo;
	}

}
