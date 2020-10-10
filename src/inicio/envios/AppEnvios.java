package inicio.envios;

import java.util.Scanner;

public class AppEnvios {

	public static void main(String[] args) {

		showMessage("bienvenido/a");
		System.out.println("Sistema de envios");
		System.out.println();

		calcularEnvio();

		showMessage("nos vemos");
	}

	private static void calcularEnvio() {

		float pesoEnvio = solicitarPeso();
		int zonaEnvio;
		;
		while (pesoEnvio != 0) {
			zonaEnvio = solicitarZona();

			Paquete paq = new Paquete(pesoEnvio, zonaEnvio);
			// paq.setPeso(pesoEnvio);

			if (paq.isTransportable()) {
				// paq.setZona(zonaEnvio);
				float precioT = paq.calcularPrecio();
				System.out.println("El valor del envio es: " + precioT);
				System.out.println();
			} else {
				showErr("El paquete es muy pesado");
				System.out.println();
			}

			pesoEnvio = solicitarPeso();
		}
	}

	private static int solicitarZona() {
		System.out.print("Ingrese zona del paquete: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static float solicitarPeso() {
		System.out.println();
		System.out.print("Ingrese peso del paquete (0 Salir): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}

	private static void showErr(String text) {
		System.out.println();
		System.out.println("*** " + text.toUpperCase() + " ***");
		System.out.println();
	}

	private static void showMessage(String text) {
		drawLine(text.length(), "-");
		System.out.println(text.toUpperCase());
		drawLine(text.length(), "-");
		System.out.println();
	}

	private static void drawLine(int size, String symbol) {
		for (int i = 0; i < size + 1; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
