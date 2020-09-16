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

		System.out.print("Ingrese número de cliente: ");
		int cliente = sc.nextInt();

		int cantClientes = 0;
		while (cliente != 0) {

			System.out.println("Hola " + cliente); // CdE

			System.out.print("Servicio: ");
			int servicio = sc.nextInt();

			switch (servicio) {
			case 1:
				System.out.println("op 1 bu");
				servicios[0] += 1;
				break;
			case 2:
				System.out.println("op 2 bu");
				servicios[1] += 1;
				break;
			case 3:
				System.out.println("op 3 bu");
				servicios[2] += 1;
				break;
			}

			System.out.println("servicio" + servicio); // CdE
			// Verificar vector
			for (int i = 0; i < CANT_SERV; i++) {
				System.out.println(servicios[i]); // CdE
			}

			cantClientes += 1;

			System.out.print("Ingrese número de cliente: ");
			cliente = sc.nextInt();
		}

		// Totales
		System.out.println("Clientes totales: " + cantClientes);
		System.out.println("Total telefonia: " + (servicios[0] * COSTO_TELF));
		System.out.println("Total clientes telefonia: " + servicios[0]);
		System.out.println("Total banda ancha: " + (servicios[1] * COSTO_BA));
		System.out.println("Total clientes banda ancha: " + servicios[1]);
		System.out.println("Total tv: " + (servicios[2] * COSTO_TV));
		System.out.println("Total clientes tv: " + servicios[2]);

		System.out.println("bye");

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
