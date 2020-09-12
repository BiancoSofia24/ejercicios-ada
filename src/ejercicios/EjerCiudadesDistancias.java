package ejercicios;

import java.util.Scanner;

public class EjerCiudadesDistancias {

	public static void main(String[] args) {

		mostrarTitulo("Sistema de estaciones");

		int vCiudadess[] = procesar();

		for (int i = 0; i < vCiudadess.length; i++) {
			dibujarTrayecto(vCiudadess[i]);
		}
	}

	private static int[] procesar() {
		// Se define int[] dado que es el tipo de dato que quiero que retorne

		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de estaciones intermedias: ");
		int estacionesT = sc.nextInt();
		int ciudades[] = new int[estacionesT];

		System.out.println();

		int distanciaT = 0;
		for (int i = 0; i < ciudades.length; i++) {
			System.out.print("Ingrese km a la estacion " + (i + 1) + ": ");
			ciudades[i] = sc.nextInt();
			distanciaT += ciudades[i];
		}
		sc.close();

		System.out.println();
		System.out.println("Distancia total: " + distanciaT + "km");
		System.out.println("Promedio entre ciudades: " + (distanciaT / estacionesT) + "km");
		System.out.println();

		return ciudades;
		// En este caso la var ciudades correspone en tipo de dato a lo que quiero
		// retornar
	}

	private static void mostrarTitulo(String titulo) {

		System.out.println(titulo.toUpperCase());
		System.out.println("------------------------------------------------------------");
		System.out.println();
	}

	// Dibuja trayecto entre ciudades
	private static void dibujarTrayecto(int distancia) {

		System.out.print("*");

		for (int i = 0; i < distancia; i++) {
			System.out.print("-"); // Estaciones = "**", imprimo x cantidad de "-" según km
		}

		System.out.print("*");
	}

}
