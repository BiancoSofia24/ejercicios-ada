package inicio.envios;

public class Paquete {

	private static int ZONA_1 = 10;
	private static int ZONA_2 = 12;
	private static int ZONA_3 = 15;
	private static int PESO_MAX = 5000;

	private float peso;
	private int zona;
	private boolean transportable;

	public Paquete(float peso, int zona) {
		this.peso = peso;
		this.zona = zona;
		this.transportable = (peso < 5000);
	}

	public boolean isTransportable() {
		return transportable;
	}

	public void setTransportable(boolean transportable) {
		this.transportable = transportable;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		if (peso < 5000) {
			transportable = true;
		} else {
			transportable = false;
		}

		this.peso = peso;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public float calcularPrecio() {
		float precio = 0;

		switch (zona) {
		case 1:
			precio = ZONA_1 * peso;
			break;
		case 2:
			precio = ZONA_2 * peso;
			break;
		case 3:
			precio = ZONA_3 * peso;
			break;
		}

		return precio;
	}
}
