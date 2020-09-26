package ejercicios;

import java.util.Scanner;

public class EjerTateti {

	private static final int CANT_COL = 3;
	private static final int CANT_FIL = 3;
	private static final int PJ1 = 1;
	private static final int PJ2 = 2;
	// private static final int PCPU = 2;

	public static void main(String[] args) {

		mostrarMensaje("tic-tac-toe");

		jugar();

		// Falta verificar posición ocupada!
	}

	public static void jugar() {
		char[][] tablero = inicializarMatriz();
		imprimirTablero(tablero);

		boolean ganador = false;
		boolean seguirJugando = true;

		while (seguirJugando) {
			Scanner scan = new Scanner(System.in);

			System.out.print("Turno J" + PJ1 + " (X) Ingresa una posición (1-9): ");
			int posJ1 = scan.nextInt();
			System.out.println();

			ubicarFicha(tablero, posJ1, PJ1);

			imprimirTablero(tablero);

			ganador = verificarGanador(tablero);
			if (ganador) {
				mostrarMensaje("¡ganaste!");
				seguirJugando = false;
			} else {

				// Opción J2 "cpu" (Jugar contra la computadora)
				// Random rand = new Random();
				// int posCpu = rand.nextInt(9) + 1;
				// ubicarFicha(tablero, porCpu, PCPU);

				System.out.print("Turno J" + PJ2 + " (O) Ingresa una posición (1-9): ");
				int posJ2 = scan.nextInt();
				System.out.println();

				ubicarFicha(tablero, posJ2, PJ2);

				imprimirTablero(tablero);

				ganador = verificarGanador(tablero);
				if (ganador) {
					mostrarMensaje("¡ganaste!");
					seguirJugando = false;
				}
			}
		}
	}

	public static boolean verificarGanador(char[][] tablero) {

		boolean fila1 = (tablero[0][0] == tablero[0][1]) && (tablero[0][0] == tablero[0][2])
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean fila2 = (tablero[1][0] == tablero[1][1]) && (tablero[1][0] == tablero[1][2])
				&& (tablero[1][0] == 'X' || tablero[1][0] == 'O');
		boolean fila3 = (tablero[2][0] == tablero[2][1]) && (tablero[2][0] == tablero[2][2])
				&& (tablero[2][0] == 'X' || tablero[2][0] == 'O');

		boolean col1 = (tablero[0][0] == tablero[1][0]) && (tablero[0][0] == tablero[2][0])
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean col2 = (tablero[0][1] == tablero[1][1]) && (tablero[0][1] == tablero[2][1])
				&& (tablero[0][1] == 'X' || tablero[0][1] == 'O');
		boolean col3 = (tablero[0][2] == tablero[1][2]) && (tablero[0][2] == tablero[2][2])
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');

		boolean diag1 = (tablero[0][0] == tablero[1][1]) && (tablero[0][0] == tablero[2][2])
				&& (tablero[0][0] == 'X' || tablero[0][0] == 'O');
		boolean diag2 = (tablero[0][2] == tablero[1][1]) && (tablero[0][2] == tablero[2][0])
				&& (tablero[0][2] == 'X' || tablero[0][2] == 'O');

		return fila1 || fila2 || fila3 || col1 || col2 || col3 || diag1 || diag2;
	}

	public static void ubicarFicha(char[][] tablero, int pos, int jugador) {

		char simbol = ' ';
		if (jugador == 1) {
			simbol = 'X';
		} else if (jugador == 2) {
			simbol = 'O';
		}

		switch (pos) {
		case 1:
			tablero[0][0] = simbol;
			break;
		case 2:
			tablero[0][1] = simbol;
			break;
		case 3:
			tablero[0][2] = simbol;
			break;
		case 4:
			tablero[1][0] = simbol;
			break;
		case 5:
			tablero[1][1] = simbol;
			break;
		case 6:
			tablero[1][2] = simbol;
			break;
		case 7:
			tablero[2][0] = simbol;
			break;
		case 8:
			tablero[2][1] = simbol;
			break;
		case 9:
			tablero[2][2] = simbol;
			break;
		default:
			break;
		}

	}

	private static char[][] imprimirTablero(char[][] tablero) {

		// Para ver el tablero
		// i -> filas / j -> columnas
		for (int i = 0; i < CANT_FIL; i++) {
			for (int j = 0; j < CANT_COL; j++) {
				System.out.print(" | ");
				System.out.print(tablero[i][j]);
			}
			System.out.println(" | ");
		}

		System.out.println();
		return tablero;
	}

	private static char[][] inicializarMatriz() {

		char[][] tablero = new char[CANT_FIL][CANT_COL];
		// Para dibujar el tablero
		// i -> filas / j -> columnas
		for (int i = 0; i < CANT_FIL; i++) {
			for (int j = 0; j < CANT_COL; j++) {
				tablero[i][j] = ' ';
			}
		}

		return tablero;
	}

	private static void mostrarMensaje(String texto) {
		dibujarLinea(texto.length(), "-");
		System.out.println(texto.toUpperCase());
		dibujarLinea(texto.length(), "-");
		System.out.println();
	}

	private static void dibujarLinea(int longitud, String simbol) {
		for (int i = 0; i < longitud + 1; i++) {
			System.out.print(simbol);
		}
		System.out.println();
	}

}