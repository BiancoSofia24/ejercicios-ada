package ejercicios;

import java.util.Scanner;

public class EjerBoleteria {

	private static final int CANT_BOLETOS = 50;
	private static final int BUTACAS = 10;
	private static final int FILAS_BUTACAS = CANT_BOLETOS / BUTACAS;

	public static void main(String[] args) {

		mostrarMensaje("sistema de venta de boletos");

		int butacas[] = inicializarSistema();

		// Teatro vacio
		dibujarSala(butacas);

		int ventas = procesarDatos(butacas);

		mostrarVentas(ventas);

		// Boletos vendidos
		dibujarSala(butacas);

	}

	private static void mostrarMensaje(String mensaje) {

		System.out.println("----------------------------------------");
		System.out.println(mensaje.toUpperCase());
		System.out.println("----------------------------------------");
		System.out.println();

	}

	private static int[] inicializarSistema() {
		int butacas[] = new int[CANT_BOLETOS];
		for (int i = 0; i < butacas.length; i++) {
			butacas[i] = 0;
		}
		return butacas;

	}

	private static void dibujarSala(int butacas[]) {

		System.out.println("|OUT|======== TARIMA ========|OUT|");
		System.out.println("|________________________________|");

		for (int j = 0; j < FILAS_BUTACAS; j++) {
			System.out.print("| ");
			for (int i = 0; i < BUTACAS; i++) {
				if (butacas[(BUTACAS * j) + i] == 0) {
					System.out.print(" o ");
				} else {
					System.out.print(" x ");
				}
			}
			System.out.println(" |");
		}

		System.out.println("|                                |");
		System.out.println("|IN|__________________________|IN|");
		System.out.println();

	}

	private static void mostrarVentas(int asientos) {

		System.out.println();
		mostrarMensaje("boletos vendidos");
		System.out.println("Hay " + asientos + " boletos vendidos");

		if (asientos != CANT_BOLETOS) {
			int boletosTotales = CANT_BOLETOS - asientos;
			System.out.println("Aún quedan " + boletosTotales + " boletos por vender");
			System.out.println();
		} else {
			System.out.println("Ya has vendido todos los boletos!");
		}

	}

	private static int procesarDatos(int butacas[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese número de butaca a ocupar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
		int asiento = sc.nextInt();

		while (asiento != 99) {

			if (esValido(asiento)) {

				if (butacas[asiento - 1] == 0) {

					butacas[asiento - 1] = 1;
					System.out.println("Butaca seleccionada");
					System.out.println();
				} else {

					System.out.println("Butaca asignada. Seleccione otra butaca");
				}

				System.out.println("Ingrese número de butaca a ocupar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
				asiento = sc.nextInt();
			} else {

				System.out.println("Boleto en butaca no autorizada");
				System.out.println("Ingrese número de butaca a ocupar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
				asiento = sc.nextInt();
			}
		}

		sc.close();

		int contador = 0;
		for (int i = 0; i < butacas.length; i++) {
			if (butacas[i] == 1) {
				contador += 1;
			}
		}

		return contador;

	}

	private static boolean esValido(int valor) {

		boolean ok = (valor - 1 >= 0 && valor - 1 < CANT_BOLETOS);
		return ok;

	}

}
