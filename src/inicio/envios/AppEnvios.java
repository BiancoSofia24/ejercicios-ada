package inicio.envios;

import java.util.Scanner;

public class AppEnvios {

	// Tarea
	// Enviar paquetes, cartas, dinero
	// Programar clases para distintos servicios con
	// sus métodos y atributos

	public static void main(String[] args) {

		Paquete.showMessage("bienvenido/a");
		System.out.println("Sistema de envios");
		System.out.println();

		calcularEnvio();

		Paquete.showMessage("nos vemos");
	}

	private static void calcularEnvio() {

		float pesoEnvio = solicitarPeso();
		int zonaEnvio;
		;
		while (pesoEnvio != 0) {
			zonaEnvio = solicitarZona();

			Paquete paq = Paquete.crear();
			// paq.setPeso(pesoEnvio);

			if (paq.isTransportable()) {
				// paq.setZona(zonaEnvio);
				float precioT = paq.calcularPrecio();
				System.out.println("El valor del envio es: " + precioT);
				System.out.println();
			} else {
				Paquete.showErr("El paquete es muy pesado");
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
}
