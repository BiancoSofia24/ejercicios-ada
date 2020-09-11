package ejercicios;

import java.util.Scanner;

public class EjerCiudadesDistancias {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Sistema de estaciones");
		System.out.println("---------------------");

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

		System.out.println("Distancia total: " + distanciaT + "km");
		System.out.println("Promedio entre paradas: " + (distanciaT / estacionesT) + "km");

		System.out.print("*");
		for (int i = 0; i < estacionesT; i++) {
			dibujarTrayecto(ciudades[i]);
		}
	}

	/*
	 * Dibuja trayecto entre ciudades
	 */
	private static void dibujarTrayecto(int distancia) {
		// Por cada estación (bucle) imprimo "*" cantidad de líneas según km
		for (int i = 0; i < distancia; i++) {
			System.out.print("-");
			// Método extra para animaciones
			/*
			 * try { Thread.sleep(200); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}

		System.out.print("*");
	}

}
