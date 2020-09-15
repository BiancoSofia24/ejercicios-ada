package ejercicios;

import java.util.Scanner;

public class EjerSistema {

	private static final int CANT_DIAS = 5;
	private static final int CANT_OPC = 4;

	public static void main(String[] args) {

		mostrarMensaje("sistema de facturacion");

		int dias[] = inicializarVector(CANT_DIAS);

		mostrarMenu();

		// Ejecución del programa
		Scanner sc = new Scanner(System.in);
		int opcMenu = sc.nextInt();

		// ejecutarMenu() incluye validación
		ejecutarMenu(opcMenu, dias);

		mostrarMensaje("gracias por usar nuestro servicio");

		sc.close();

	}

	private static void ejecutarMenu(int opcion, int vector[]) {

		Scanner sc = new Scanner(System.in);
		while (opcion > 0) {

			if (opcion >= CANT_OPC) {

				mostrarError("opción inválida");

				mostrarMenu();
				opcion = sc.nextInt();

			} else {

				switch (opcion) {
				case 1:
					mostrarMensaje("agregar total de importe diario");

					// NO lee el método ingresarDatos(dias)
					for (int i = 0; i < vector.length; i++) {
						System.out.print("Total importe día " + (i + 1) + ": ");
						vector[i] = sc.nextInt();
					}

					System.out.println();
					mostrarMenu();
					opcion = sc.nextInt();

					break;
				case 2:
					mostrarMensaje("listado de importes diario");

					listarDatos(vector);

					mostrarMenu();
					opcion = sc.nextInt();

					break;
				case 3:
					mostrarMensaje("modificar total de importe diario");

					mostrarMenu();
					opcion = sc.nextInt();

					break;
				}
			}
		}

		sc.close();
	}

	private static void listarDatos(int[] vector) {

		int acumulador = 0;
		for (int i = 0; i < vector.length; i++) {
			System.out.println("Total del día " + (i + 1) + ": " + vector[i]);
			acumulador += vector[i];
		}
		System.out.println();
		System.out.println("Total de importes: " + acumulador);
		System.out.println("Importe promedio: " + (acumulador / CANT_DIAS));
		System.out.println();
	}

	// No funciona. No se lee el menú luego de usar el método
	private static void ingresarDatos(int[] vector) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < vector.length; i++) {
			System.out.print("Total importe día " + (i + 1) + ": ");
			vector[i] = sc.nextInt();
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

	private static void mostrarMenu() {

		System.out.println("MENÚ: ");
		System.out.println("(1) Agregar");
		System.out.println("(2) Listar");
		System.out.println("(3) Modificar");
		System.out.println("(0) Salir");
		System.out.println();

	}

	private static void mostrarMensaje(String mensaje) {

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
