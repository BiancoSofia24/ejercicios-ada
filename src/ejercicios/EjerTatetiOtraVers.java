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

		visualizar(tablero);

		boolean ganador = false;
		int cont = 0;
		int jugador = 1;
		while (!ganador && cont < 9) {
			cont++;
			jugador = cont % 2;
			ganador = jugar(jugador, tablero);
		}
	}

	private static boolean jugar(int jugador, char[][] tablero) {

		cambiarTurno(jugador);

		int fila = elegirFila();
		int col = elegirCol();

		boolean ganador = false;

		while (tablero[fila - 1][col - 1] == 'X' || tablero[fila - 1][col - 1] == 'O') {
			System.out.println("Posición inválida");
			System.out.println();
			fila = elegirFila();
			col = elegirCol();
		}

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

		return ganador;
	}

	private static int elegirCol() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Ingrese columna en  la que desea ubicarse (1-3): ");
		int col = scan.nextInt();
		while (col <= 0 || col > 3) {
			System.out.println();
			System.out.println("Columna inválida");
			System.out.print("Ingrese columna en la que desea ubicarse (1-3): ");
			col = scan.nextInt();
		}

		System.out.println();

		return col;
	}

	private static int elegirFila() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Ingrese fila en la que desea ubicarse (1-3): ");
		int fila = scan.nextInt();
		while (fila <= 0 || fila > 3) {
			System.out.println();
			System.out.println("Fila inválida");
			System.out.print("Ingrese fila en la que desea ubicarse (1-3): ");
			fila = scan.nextInt();
		}

		System.out.println();

		return fila;
	}

	private static void cambiarTurno(int jugador) {
		// Alternar turno del jugador
		if (jugador == 0) {
			System.out.println("Turno del J" + (jugador + 2) + " (O)");
		} else {
			System.out.println("Turno del J" + jugador + " (X)");
		}

		System.out.println();
	}

	private static boolean verificarGanador(char[][] matriz) {
		boolean fila1 = (matriz[0][0] == matriz[0][1]) && (matriz[0][0] == matriz[0][2])
				&& (matriz[0][0] == 'X' || matriz[0][0] == 'O');
		boolean fila2 = (matriz[1][0] == matriz[1][1]) && (matriz[1][0] == matriz[1][2])
				&& (matriz[1][0] == 'X' || matriz[1][0] == 'O');
		boolean fila3 = (matriz[2][0] == matriz[2][1]) && (matriz[2][0] == matriz[2][2])
				&& (matriz[2][0] == 'X' || matriz[2][0] == 'O');

		boolean col1 = (matriz[0][0] == matriz[1][0]) && (matriz[0][0] == matriz[2][0])
				&& (matriz[0][0] == 'X' || matriz[0][0] == 'O');
		boolean col2 = (matriz[0][1] == matriz[1][1]) && (matriz[0][1] == matriz[2][1])
				&& (matriz[0][1] == 'X' || matriz[0][1] == 'O');
		boolean col3 = (matriz[0][2] == matriz[1][2]) && (matriz[0][2] == matriz[2][2])
				&& (matriz[0][2] == 'X' || matriz[0][2] == 'O');

		boolean diag1 = (matriz[0][0] == matriz[1][1]) && (matriz[0][0] == matriz[2][2])
				&& (matriz[0][0] == 'X' || matriz[0][0] == 'O');
		boolean diag2 = (matriz[0][2] == matriz[1][1]) && (matriz[0][2] == matriz[2][0])
				&& (matriz[0][2] == 'X' || matriz[0][2] == 'O');

		return fila1 || fila2 || fila3 || col1 || col2 || col3 || diag1 || diag2;
	}

	private static void visualizar(char[][] matriz) {
		// A forma de instructivo
		System.out.println("Columnas: 1   2   3");
		for (int i = 0; i < CANT_FIL; i++) {
			System.out.print("Fila: " + (i + 1));
			for (int j = 0; j < CANT_COL; j++) {
				System.out.print(" | ");
				System.out.print(matriz[i][j]);
			}
			System.out.println(" | ");
		}

		System.out.println();
	}

	private static char[][] imprimirTablero(char[][] matriz) {
		// Para imprimir en pantalla la matriz
		// i -> filas / j -> columnas
		for (int i = 0; i < CANT_FIL; i++) {
			for (int j = 0; j < CANT_COL; j++) {
				System.out.print(" | ");
				System.out.print(matriz[i][j]);
			}
			System.out.println(" | ");
		}

		System.out.println();

		return matriz;
	}

	private static char[][] inicializarMatriz(int fila, int col) {
		// Para rellenar la matriz
		char[][] matriz = new char[fila][col];

		// i -> filas / j -> columnas
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < col; j++) {
				matriz[i][j] = ' ';
			}
		}

		return matriz;
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
