package ejercicios;

import java.util.Scanner;

public class EjerBoleteria {

	private static final int CANT_BOLETOS = 50;
	private static final int BUTACAS = 10;
	private static final int FILAS_BUTACAS = 5;

	public static void main(String[] args) {

		mostrarTitulo("sistema de venta de boletos");

		dibujarTeatro();

		int butacasVendidas = procesarDatos();

		mostrarDatos(butacasVendidas);

	}

	private static void dibujarTeatro() {

		System.out.println("________________________________");

		for (int j = 0; j < FILAS_BUTACAS; j++) {
			System.out.print("|");
			for (int i = 0; i < BUTACAS; i++) {
				System.out.print(" - ");
			}
			System.out.println("|");
		}

		System.out.println("|______________________________|");
		System.out.println("|=========== TARIMA ===========|");
		System.out.println();

	}

	private static void mostrarDatos(int asientos) {

		System.out.println();
		mostrarTitulo("butacas vendidas");
		System.out.println("Hay " + asientos + " butacas vendidas");

		if (asientos != CANT_BOLETOS) {
			int boletosTotales = CANT_BOLETOS - asientos;
			System.out.println("Aún quedan " + boletosTotales + " por vender");
			System.out.println("¡Sigue vendiendo!");
		} else {
			System.out.println("Ya has vendido todos los boletos!");
			System.out.println("Vendedor del mes");
		}

	}

	private static int procesarDatos() {

		Scanner sc = new Scanner(System.in);
		int boletos[] = new int[CANT_BOLETOS];
		for (int i = 0; i < boletos.length; i++) {
			boletos[i] = 0;
		}

		System.out.println("Ingrese número de butaca a comprar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
		int butaca = sc.nextInt();

		while (butaca != 99) {

			if (esValido(butaca)) {

				if (boletos[butaca - 1] == 0) {

					boletos[butaca - 1] = 1;
					System.out.println("Butaca seleccionada");
					System.out.println();
				} else {

					System.out.println("Butaca vendida. Seleccione otra butaca");
				}

				System.out
						.println("Ingrese número de butaca a comprar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
				butaca = sc.nextInt();
			} else {

				System.out.println("Boleto en butaca no autorizada");
				System.out
						.println("Ingrese número de butaca a comprar. Entre 1 y " + CANT_BOLETOS + " (99 para salir)");
				butaca = sc.nextInt();
			}
		}

		sc.close();

		int contador = 0;
		for (int i = 0; i < boletos.length; i++) {
			if (boletos[i] == 1) {
				contador += 1;
			}
		}

		return contador;

	}

	private static boolean esValido(int asientos) {

		boolean ok = (asientos - 1 >= 0 && asientos - 1 < CANT_BOLETOS);
		return ok;

	}

	private static void mostrarTitulo(String titulo) {

		System.out.println(titulo.toUpperCase());
		System.out.println("------------------------------------------------------------");
		System.out.println();

	}
}
