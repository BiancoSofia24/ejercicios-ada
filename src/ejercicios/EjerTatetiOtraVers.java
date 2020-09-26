package ejercicios;

import java.util.Scanner;

public class EjerTatetiOtraVers {

	private static final int CANT_FIL = 3;
	private static final int CANT_COL = 3;

	public static void main(String[] args) {

		/*
		 * Para realizar 1- Dibujar tablero 2- Mostrar el tablero 3- Manejar los turnos
		 * 4- Verificar celda a usar NO ocupada 5- Verificar si un jugador ganó { - Por
		 * fila - Por columna - Por diagonal } 6- Empate? 7- Cambiar jugador por turno
		 */

		mostrarMensaje("juguemos tic-tac-toe");

		char[][] tablero = inicializarMatriz(CANT_FIL, CANT_COL);

		imprimirTablero(tablero);

		boolean ganador = false;
		int cont = 0;
		int jugador = 1;
		while (!ganador && cont < 9) {
			cont++;
			jugador = cont % 2;
			ganador = turno(jugador, tablero);
		}
	}

	private static boolean turno(int jugador, char[][] tablero) {
		Scanner scan = new Scanner(System.in);

		if (jugador == 0) {
			System.out.println("Turno del J" + (jugador + 2));
		} else {
			System.out.println("Turno del J" + jugador);
		}

		System.out.print("Ingrese fila en la que desea ubicarse (1-3): ");
		int fila = scan.nextInt();
		System.out.print("Ingrese columna en  la que desea ubicarse (1-3): ");
		int col = scan.nextInt();
		System.out.println();

		boolean ganador = false;
		if (tablero[fila - 1][col - 1] == 'X' || tablero[fila - 1][col - 1] == 'O') {
			System.out.println("POsición inválida. Pierdes el turno");
			System.out.println();
		} else {
			if (jugador == 1) {
				tablero[fila - 1][col - 1] = 'X';
			} else {
				tablero[fila - 1][col - 1] = 'O';
			}

			ganador = verificarGanador(tablero);

			imprimirTablero(tablero);

			if (ganador) {
				if (jugador == 0) {
					mostrarMensaje("¡ganaste J" + (jugador + 2) + "!");
				} else {
					mostrarMensaje("¡ganaste J" + jugador + "!");
				}
			}
		}

		return ganador;
	}

	private static int posicion(char[][] tablero, int pos) {

		switch (pos) {
		case 1:
			pos = tablero[0][0];
			break;
		case 2:
			pos = tablero[0][1];
			break;
		case 3:
			pos = tablero[0][2];
			break;
		case 4:
			pos = tablero[1][0];
			break;
		case 5:
			pos = tablero[1][1];
			break;
		case 6:
			pos = tablero[1][2];
			break;
		case 7:
			pos = tablero[2][1];
			break;
		case 8:
			pos = tablero[2][1];
			break;
		case 9:
			pos = tablero[2][2];
			break;
		default:
			break;
		}

		return pos;
	}

	private static boolean verificarGanador(char[][] tablero) {
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

	private static char[][] inicializarMatriz(int fila, int col) {

		char[][] tablero = new char[fila][col];
		// Para dibujar el tablero
		// i -> filas / j -> columnas
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < col; j++) {
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
