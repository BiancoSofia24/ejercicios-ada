package inicio.teatro;

import java.util.Scanner;

public class AppTeatro {

	private static final int BUTACAS_T = 50;
	private static final int COLS = 10;
	private static final int FILAS = 5;

	public static void main(String[] args) {
		showMessage("sistema de venta de boletos");

		Butaca[] butacas = new Butaca[BUTACAS_T];
		int[] asiento = setUpArray(BUTACAS_T);

		for (int i = 0; i < butacas.length; i++) {
			butacas[i] = new Butaca();
		}

		dibujarSala(asiento);

		int pos = solicitarPosicion("boleto (1-50 / 0 Salir)");

		while (pos != 0) {
			while (pos > 50) {
				showErr("butaca inexistente");
				pos = solicitarPosicion("boleto (1-50 / 0 Salir)");
			}

			pos -= 1;
			Butaca butaca = new Butaca(pos);
			// butaca.setPosicion(pos);

			if (butacas[pos].isOcupado()) {
				showErr("error");
				System.out.println("Butaca " + (butacas[pos].getPosicion() + 1) + " ya vendida");
				System.out.println();
			} else {
				// butaca.setOcupado(true);
				butacas[pos] = butaca;
				asiento[pos] = 1;
				System.out.println("Butaca asignada");
				System.out.println();
			}

			pos = solicitarPosicion("boleto (1-50 / 0 Salir)");

		}

		System.out.println();
		showMessage("butacas vendidas");

		dibujarSala(asiento);
		System.out.println();

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

	private static int[] setUpArray(int dimension) {
		int vector[] = new int[dimension];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
		}
		return vector;
	}

	private static void dibujarSala(int[] asiento) {

		System.out.println("|OUT|======== TARIMA ========|OUT|");
		System.out.println("|________________________________|");

		for (int j = 0; j < FILAS; j++) {
			System.out.print("| ");
			for (int i = 0; i < COLS; i++) {
				if (asiento[(COLS * j) + i] == 0) {
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
