package ejercicios;

import java.util.Scanner;

public class EjerComunicaciones {

	private static final int COSTO_TELF = 10;
	private static final int COSTO_BA = 15;
	private static final int COSTO_TV = 20;
	private static final int CANT_SERV = 3;

	public static void main(String[] args) {

		/*
		 * Una empresa de comunicaciones ofrece servicio de telefonía, banda ancha y tv
		 * digital. Cada uno de los servicios tiene un precio diferente (Telefonía: 10,
		 * Banda ancha: 15, TV, 20). Se desea contar cuántos clientes optan por cada
		 * servicio para luego conocer la facturación de cada uno de los servicios. Se
		 * deben ingresar los clientes por número (cliente = 0 para finalizar)
		 */

		Scanner sc = new Scanner(System.in);
		int servicios[] = inicializarVector(CANT_SERV);

		// Verficar vector
		for (int i = 0; i < CANT_SERV; i++) {
			System.out.println(servicios[i]);
		}

		mostrarMensaje("servicios de comunicaciones");

		procesarDatos(servicios);

		mostrarVentas(servicios);

		mostrarMensaje("gracias por usar nuestro sistema");

		sc.close();
	}

	private static void mostrarVentas(int[] servicios) {

		System.out.println();
		System.out.println("Servicio 1: Telefónia. Servicio 2: Banda Ancha. Servicio 3: TV");

		for (int i = 0; i < CANT_SERV; i++) {
			System.out.println("La cantidad de clientes para el servicio " + (i + 1) + " es: " + servicios[i]);
		}

		int totalTelf = servicios[0] * COSTO_TELF;
		int totalBa = servicios[1] * COSTO_BA;
		int totalTv = servicios[2] * COSTO_TV;
		int total = totalTelf + totalBa + totalTv;

		System.out.println("Total recaudado: $" + total);
	}

	private static void procesarDatos(int[] servicios) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese número de cliente (0 para Salir): ");
		int cliente = sc.nextInt();

		while (cliente != 0) {

			if (cliente > 0) {

				System.out.println();
				System.out.println("Servicio 1: Telefónia. Servicio 2: Banda Ancha. Servicio 3: TV");
				System.out.println("Ingrese servicio solicitados para el cliente " + cliente + " (0 para Salir)");
				System.out.print("Servicio: ");
				int servicio = sc.nextInt();
				while (servicio != 0) {

					if (servicio > 0 && servicio <= CANT_SERV) {

						servicios[servicio - 1] += 1;
					} else {

						System.out.println("Número de servicio inválido");
					}

					System.out.print("Servicio: ");
					servicio = sc.nextInt();
				}
			} else {

				System.out.println("Número de cliente inválido");
			}

			System.out.print("Ingrese número de cliente (0 para Salir): ");
			cliente = sc.nextInt();
		}

		sc.close();
	}

	private static int[] inicializarVector(int dimension) {

		int vector[] = new int[dimension];
		for (int i = 0; i < vector.length; i++) {

			vector[i] = 0;
		}

		return vector;
	}

	private static void mostrarMensaje(String texto) {

		System.out.println("-----------------------------------");
		System.out.println(texto.toUpperCase());
		System.out.println("-----------------------------------");
		System.out.println();
	}
}
