package ejercicios;

import java.util.Scanner;

public class EjerSistema {

	private static final int CANT_DIAS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mostrarMensaje("sistema de facturacion");

		float dias[] = inicializarVector(CANT_DIAS);

		// Ejecución del programa
		int opcMenu = mostrarMenu();

		// Cantidad de opciones = 3, Salir no se incluye como alternativa
		// ejecutarMenu() incluye validación
		ejecutarMenu(opcMenu, 3, dias);

		mostrarMensaje("gracias por usar nuestro servicio");
	}

	private static void ejecutarMenu(int opcion, int cantOpcionesMenu, float vector[]) {
		while (opcion != 0) {
			if (opcion < 0 && opcion > cantOpcionesMenu) {
				mostrarError("opción inválida");

				opcion = mostrarMenu();
			} else {
				switch (opcion) {
				case 1:
					mostrarMensaje("agregar total de importe diario");

					ingresarDatos(vector);

					opcion = mostrarMenu();
					break;
				case 2:
					mostrarMensaje("listado de importes diario");

					listarDatos(vector);

					opcion = mostrarMenu();
					break;
				case 3:
					mostrarMensaje("modificar total de importe diario");

					modificarDatos(vector);

					opcion = mostrarMenu();
					break;
				}
			}
		}
	}

	private static String[] nombresVector() {
		String nombres[] = new String[CANT_DIAS];
		nombres[0] = "Lunes";
		nombres[1] = "Martes";
		nombres[2] = "Miércoles";
		nombres[3] = "Jueves";
		nombres[4] = "Viernes";

		return nombres;
	}

	private static float[] modificarDatos(float[] vector) {
		Scanner sc = new Scanner(System.in);
		String nombres[] = nombresVector();

		System.out.print("Día a modificar (1 Lunes ... 5 Viernes / 0 para Salir): ");
		int dia = sc.nextInt();

		while (dia != 0) {
			System.out.println();
			System.out.println("Importe actual día " + nombres[dia - 1] + ": " + vector[dia - 1]);
			System.out.print("Ingresar nuevo importe: ");
			vector[dia - 1] = sc.nextFloat();
			System.out.println();

			System.out.print("Día a modificar (1 Lunes ... 5 Viernes / 0 para Salir): ");
			dia = sc.nextInt();
		}

		System.out.println();
		return vector;
	}

	private static void listarDatos(float[] vector) {
		String nombres[] = nombresVector();

		float acumulador = 0f;
		for (int i = 0; i < vector.length; i++) {
			System.out.println("Total del día " + nombres[i] + ": " + vector[i]);
			acumulador += vector[i];
		}

		System.out.println();
		System.out.println("Total de importes: " + acumulador);
		System.out.println("Importe promedio: " + (acumulador / CANT_DIAS));
		System.out.println();
	}

	private static void ingresarDatos(float[] vector) {
		Scanner sc = new Scanner(System.in);

		String nombres[] = nombresVector();
		for (int i = 0; i < vector.length; i++) {
			System.out.print("Total importe día " + nombres[i] + ": ");
			vector[i] = sc.nextFloat();
		}
		System.out.println();
	}

	private static float[] inicializarVector(int dimension) {
		float vector[] = new float[dimension];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
		}
		return vector;
	}

	private static int mostrarMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("MENÚ: ");
		System.out.println("(1) -> Agregar");
		System.out.println("(2) -> Listar");
		System.out.println("(3) -> Modificar");
		System.out.println("(0) -> Salir");
		System.out.println();
		System.out.print("Opción: ");
		int opcion = sc.nextInt();

		return opcion;
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println(mensaje.toUpperCase());
		System.out.println("-----------------------------------");
		System.out.println();

	}

	private static void mostrarError(String mensaje) {
		System.out.println("*** " + mensaje.toUpperCase() + " ***");
		System.out.println();
	}
}
