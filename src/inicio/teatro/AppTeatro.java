package inicio.teatro;

import java.util.Scanner;

public class AppTeatro {

	private static final int BUTACAS_T = 50;
	private static final int COLS = 10;
	private static final int FILAS = 5;

	public static void main(String[] args) {
		showMessage("sistema de venta de boletos");

		Butaca[] butacas = new Butaca[BUTACAS_T];

		for (int i = 0; i < butacas.length; i++) {
			butacas[i] = new Butaca();
		}

		dibujarSala(butacas);

		int pos = solicitarPosicion("boleto (1-50 / 0 Salir)");

		while (pos != 0) {
			pos -= 1;

			Butaca butaca = new Butaca();
			butaca.setPosicion(pos);

			if (butacas[pos].isOcupado()) {
				showErr("error");
				System.out.println("Butaca " + (butacas[pos].getPosicion() + 1) + " ya vendida");
				System.out.println();
			} else {
				butaca.setOcupado(true);
				butacas[pos] = butaca;
				System.out.println("Butaca asignada");
				System.out.println();
			}

			pos = solicitarPosicion("boleto (1-50 / 0 Salir)");

		}

		System.out.println();
		showMessage("butacas vendidas");
		for (int i = 0; i < butacas.length; i++) {
			if (butacas[i].isOcupado()) {
				System.out.println("Butaca " + (butacas[i].getPosicion() + 1) + " ocupada");
			}
		}

		/*
		 * int col; int fila; while (pos != 99) { col = solicitarPosicion("columna");
		 * fila = solicitarPosicion("fila");
		 * 
		 * Butaca butaca = new Butaca(); butaca.setPosicion(pos); if
		 * (butacas[pos].isOcupado()) { showErr("butaca no disponible"); } else {
		 * butaca.setOcupado(true); butacas[pos] = butaca;
		 * System.out.println("Butaca vendida!"); }
		 * 
		 * pos = solicitarPosicion("posicion"); }
		 * 
		 * for (int i = 0; i < butacas.length; i++) { if (butacas[i].isOcupado()) {
		 * System.out.println("Butaca ocupada " + butacas[i].getPosicion()); } }
		 * 
		 */
	}

	private static void dibujarSala(Butaca[] butacas) {

		System.out.println("|OUT|======== TARIMA ========|OUT|");
		System.out.println("|________________________________|");

		for (int j = 0; j < FILAS; j++) {
			System.out.print("| ");
			for (int i = 0; i < COLS; i++) {
				System.out.print(" o ");
			}
			System.out.println(" |");
		}

		System.out.println("|                                |");
		System.out.println("|IN|__________________________|IN|");
		System.out.println();

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
