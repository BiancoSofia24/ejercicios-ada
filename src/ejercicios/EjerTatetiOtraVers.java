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

		mostrarMensaje("tic-tac-toe");

		jugar();

	}

	private static void jugar() {
		char[][] tablero = inicializarMatriz(CANT_FIL, CANT_COL);

		visualizar(tablero);

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Quieres jugar?");
		System.out.print("¡Claro que sí! (1) / No, no quiero :( (0) -> ");
		int instr = sc.nextInt();
		System.out.println();

		while (instr != 0) {

			tablero = inicializarMatriz(CANT_FIL, CANT_COL);

			boolean ganador = false;
			int cont = 0;
			int jugador = 1;
			while (!ganador && cont < 9) {
				cont++;
				jugador = cont % 2;
				ganador = correrJuego(jugador, tablero);
			}

			if (cont == 9) {
				mostrarMensaje("fue empate");
			}

			System.out.println("¿Volver a jugar?");
			System.out.print("¡Claro que sí! (1) / No, no quiero :( (0) -> ");
			instr = sc.nextInt();
			System.out.println();
		}

		if (instr == 0) {
			System.out.println("Te veré volver...");
			mostrarMensaje("¡hasta luego!");
		}

	}

	/**
	 * Corre el juego. Incluye validaciones y verificaciones
	 * 
	 * @param jugador
	 * @param tablero
	 * @return
	 */
	private static boolean correrJuego(int jugador, char[][] tablero) {

		cambiarTurno(jugador);

		int fila = elegirPosicion("Fila");
		int col = elegirPosicion("Columna");

		boolean ganador = false;

		while (tablero[fila - 1][col - 1] == 'X' || tablero[fila - 1][col - 1] == 'O') {
			mostrarError("posición ya ocupada");
			System.out.println("¡Inténtalo de nuevo!");
			System.out.println();
			fila = elegirPosicion("Fila");
			col = elegirPosicion("Columna");
		}

		if (jugador == 1) {
			tablero[fila - 1][col - 1] = 'X';
		} else {
			tablero[fila - 1][col - 1] = 'O';
		}

		ganador = verificarGanador(tablero);

		imprimirTablero(tablero);

		if (ganador) {
			definirGanador(jugador);
		}

		return ganador;
	}

	/**
	 * Define jugador ganador
	 * 
	 * @param jugador
	 */
	private static void definirGanador(int jugador) {
		if (jugador == 0) {
			mostrarMensaje("*.* ¡ganaste J" + (jugador + 2) + "! *.*");
		} else {
			mostrarMensaje("*.* ¡ganaste J" + jugador + "! *.*");
		}
	}

	/**
	 * Definir fila y columna
	 * 
	 * @param tipo
	 * @return
	 */
	private static int elegirPosicion(String tipo) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Ingresa " + tipo + " en la que deseas ubicarte (1-3): ");
		int pos = scan.nextInt();
		while (pos <= 0 || pos > 3) {
			mostrarError(tipo + " inválida");
			System.out.print("Ingresa " + tipo + " en la que deseas ubicarte (1-3): ");
			pos = scan.nextInt();
		}

		System.out.println();

		return pos;
	}

	/**
	 * Alternar turno del jugador
	 * 
	 * @param jugador
	 */
	private static void cambiarTurno(int jugador) {
		if (jugador == 0) {
			System.out.println("Turno J" + (jugador + 2) + " (O)");
		} else {
			System.out.println("Turno J" + jugador + " (X)");
		}
	}

	/**
	 * Validar ganador true / false
	 * 
	 * @param matriz
	 * @return
	 */
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

	/*
	 * A forma de instructivo
	 */
	private static void visualizar(char[][] matriz) {
		System.out.println("¡Vamos a jugar!");
		System.out.println();
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

	/*
	 * Imprimir en pantalla la matriz i -> filas / j -> columnas
	 */
	private static char[][] imprimirTablero(char[][] matriz) {
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

	/*
	 * Rellenar la matriz i -> filas / j -> columnas
	 */
	private static char[][] inicializarMatriz(int fila, int col) {
		char[][] matriz = new char[fila][col];

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

	private static void mostrarError(String texto) {
		System.out.println("*** " + texto.toUpperCase() + " ***");
		System.out.println();
	}
}
