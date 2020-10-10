package inicio.teatro;

import java.util.Scanner;

public class AppTeatro {

	private static final int BUTACAS_T = 50;
	private static final int COLS = 10;
	private static final int FILAS = 5;

	public static void main(String[] args) {
		showMessage("sistema de venta de boletos");

		Butaca[] butacas = new Butaca[BUTACAS_T];
		int[] asiento = Butaca.setUpArray(BUTACAS_T);

		for (int i = 0; i < butacas.length; i++) {
			butacas[i] = new Butaca(i);
		}

		Butaca.dibujarSala(asiento, COLS, FILAS);

		int pos = solicitarPosicion("boleto (1-50 / 0 Salir)");

		while (pos != 0) {
			while (pos > 50) {
				showErr("butaca inexistente");
				pos = solicitarPosicion("boleto (1-50 / 0 Salir)");
			}

			pos -= 1;

			// *
			// Conceptos de Herencia entre Objetos
			int fila = 1;
			int col = 1;
			Butaca butaca = Butaca.crear(pos, fila, col);
			// Butaca es clase hijo
			// ButacaVip es clase padre
			ButacaVip bVIP = new ButacaVip(pos);
			ButacaVip bVIP2 = new ButacaVip(pos, true);
			// ButacaVip "hereda" atributos de Butaca
			bVIP.setPosicion(pos);
			// *

			if (butacas[pos].isOcupado()) {
				showErr("error");
				System.out.println("Butaca " + (butacas[pos].getPosicion() + 1) + " ya vendida");
				System.out.println();
			} else {
				butacas[pos].setOcupado(true);
				asiento[pos] = 1;
				System.out.println("Butaca asignada");
				System.out.println();
			}

			pos = solicitarPosicion("boleto (1-50 / 0 Salir)");
		}

		System.out.println();
		showMessage("butacas vendidas");

		Butaca.dibujarSala(asiento, COLS, FILAS);

		for (int i = 0; i < butacas.length; i++) {
			if (butacas[i].isOcupado()) {
				System.out.println("Butaca " + (butacas[i].getPosicion() + 1) + " ocupada");
			}
		}
	}

	private static int solicitarPosicion(String str) {
		System.out.print("Ingrese número de " + str + ": ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
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
