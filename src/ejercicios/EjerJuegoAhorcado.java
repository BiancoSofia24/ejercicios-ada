package ejercicios;

import java.util.Scanner;

public class EjerJuegoAhorcado {

	private static final int MIN_PLBRA = 4;
	private static final int MAX_PLBRA = 10;
	private static final int MAX_ERR = 10;

	public static void main(String[] args) {

		mostrarMensaje("el ahorcado");

		jugar();

	}

	private static void jugar() {

		Scanner sc = new Scanner(System.in);

		System.out.println("¿Empezar a jugar? (1 para ¡Dale! / 0 para Ni en chiste)");
		int jugar = sc.nextInt();

		// Ingresar dificultad! facil 10 normal 6 dificil 3

		while (jugar != 0) {

			if (jugar == 1) {

				String palabra = generarPalabra();

				int errores = adivinar(palabra);

				mostrarPuntos(errores);

				mostrarMensaje("¡gracias por jugar!");
			} else {

				System.out.println("Ingresaste el número equivocado");
			}

			System.out.println();
			System.out.println("¿Empezar a jugar? (1 para ¡Dale! / 0 para Ni en chiste)");
			jugar = sc.nextInt();
		}

		mostrarMensaje("¡cobarde!");
		System.out.println("Tú te lo pierdes...");

	}

	/**
	 * @param intentos
	 */
	private static void mostrarPuntos(int intentos) {

		int ptos = MAX_PLBRA - intentos;

		System.out.println("Tu maravilloso puntaje fue: " + ptos);
		System.out.println();
	}

	/**
	 * @param palabra
	 * @return cantErrores
	 */
	private static int adivinar(String palabra) {

		Scanner sc = new Scanner(System.in);

		// Pedir letra
		System.out.println();
		System.out.println("Escribe una letra (con tu teclado) para intentar adivinar");
		System.out.println("Si completaste la palabra ingresa un 0 y veras tu puntuación");
		System.out.print("Letra: ");
		String letra = sc.next();
		System.out.println();

		boolean resultado[] = new boolean[palabra.length()];
		int cantAciertos = 0;
		int cantErrores = 0;
		// Evaluar cantidadAcierto <
		while (cantAciertos < palabra.length() && cantErrores != MAX_ERR) {

			int posicion = palabra.indexOf(letra); // Si letra !E = -1

			if (posicion != -1) {

				resultado[posicion] = posicion != -1;
				cantAciertos++;
			} else {

				cantErrores++;
			}

			for (int i = 0; i < palabra.length(); i++) {

				if (resultado[i]) {

					System.out.print(" " + palabra.charAt(i) + " ");
				} else {

					System.out.print(" _ ");
				}
			}

			System.out.println("Llevas " + cantErrores + " errores");

			System.out.println();
			System.out.println("Escribe una letra (con tu teclado) para intentar adivinar");
			System.out.println("Si completaste la palabra ingresa un 0 y veras tu puntuación");
			System.out.print("Letra: ");
			letra = sc.next();
			System.out.println();
		}

		if (cantErrores == MAX_ERR) {
			System.out.println();
			System.out.println("¡Perdiste!");
			System.out.println("Vuelve a intentarlo");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("¡Ganaste!");
			System.out.println("Tu premio fue este mensaje...");
			System.out.println();
		}

		return cantErrores;
	}

	/**
	 * @return palabra
	 */
	private static String generarPalabra() {

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("Pídele a tu amig@ que ingrese una palabra para empezar a jugar.");
		System.out.println("¡No puedes mirar!");
		System.out.println();
		System.out.print("Palabra: ");
		String palabra = sc.next();

		int longPalabra = palabra.length();
		while (longPalabra < MIN_PLBRA || longPalabra > MAX_PLBRA) {
			System.out.println();
			System.out.println("¡Esa palabra es demasiado larga para este sencillo juego!");
			System.out.println("Ingresa una palabra entre " + MIN_PLBRA + " y " + MAX_PLBRA + " letras.");
			System.out.println();
			System.out.print("Palabra: ");
			palabra = sc.next();
		}

		return palabra;
	}

	private static void mostrarMensaje(String texto) {

		System.out.println("-----------------------------------");
		System.out.println(texto.toUpperCase());
		System.out.println("-----------------------------------");
		System.out.println();
	}
}
