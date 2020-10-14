package inicio.envio2;

import java.util.Scanner;

public class Paquetes {

	// Constantes
	// Precio por zona
	private static int PRECIO_Z1 = 5;
	private static int PRECIO_Z2 = 8;
	private static int PRECIO_Z3 = 10;

	// Variables globales
	private float pesoEnvio;
	private int zona;
	private boolean transportable;

	public float getCarga() {
		return pesoEnvio;
	}

	public void setCarga(float peso) {
		this.pesoEnvio = peso;
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
		this.pesoEnvio = peso;
		this.transportable = false;
	}

	public Paquetes(int zona) {
		this.zona = zona;
	}

	// Métodos
	public float calcularPrecio(float pesoEnvio, int zona) {
		float precio = 0;

		switch (zona) {
		case 1:
			precio = PRECIO_Z1 * pesoEnvio;
			break;
		case 2:
			precio = PRECIO_Z2 * pesoEnvio;
			break;
		case 3:
			precio = PRECIO_Z3 * pesoEnvio;
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

	public static float solicitarPeso() {
		System.out.print("Indique peso de su paquete / documento (Kg): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}

	public static float validarPeso() {
		float envio = solicitarPeso();

		while (envio < 0) {
			Utiles.showErr("opción erronea");
			envio = solicitarPeso();
		}

		return envio;
	}

	public String definirZona(int zona) {
		String region = "";

		switch (zona) {
		case 1:
			region = "Sur Ámerica";
			break;
		case 2:
			region = "Norte Ámerica";
			break;
		case 3:
			region = "Europa";
			break;
		}

		return region;
	}

}
