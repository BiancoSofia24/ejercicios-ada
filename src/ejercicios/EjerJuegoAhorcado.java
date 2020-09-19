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
	 * @param errores
	 */
	private static void dibujar(int errores) {
		switch (errores) {
		case 1:
			System.out.println("Uy...");
			System.out.println("   _______");
			System.out.println();
			break;
		case 2:
			System.out.println("Construyendo...");
			System.out.println("   _______");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println();
			break;
		case 3:
			System.out.println("Construyendo...");
			System.out.println("   _______");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 4:
			System.out.println("¿Qué tenemos por aquí?");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 5:
			System.out.println("Quiero tu cabeza :)");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 6:
			System.out.println("¿Me parece o estás muy delgado/a?");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("     |   |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 7:
			System.out.println("Chan, chan...");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("    (|   |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 8:
			System.out.println("¡Te estás quedando sin oportunidades!");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("    (|)  |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 9:
			System.out.println("Te queda una oportunidad para desperdiciar... :D");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("    (|)  |");
			System.out.println("    |    |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		case 10:
			System.out.println("¡Lo siento! Creo...");
			System.out.println("   _______");
			System.out.println("     |   |");
			System.out.println("     O   |");
			System.out.println("    (|)  |");
			System.out.println("    | |  |");
			System.out.println("         |");
			System.out.println("   ______|___");
			System.out.println();
			break;
		default:
			System.out.println("¡Vas bien!");
			System.out.println();
		}
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

		System.out.println();
		System.out.println("Escribe una letra (con tu teclado) para intentar adivinar");
		System.out.print("Letra: ");
		String letra = sc.next();
		System.out.println();

		// letrasOk[false, false, false, ...] dimension = longPalabra
		boolean letrasOk[] = new boolean[palabra.length()];
		int cantAciertos = 0;
		int cantErrores = 0;
		while (cantAciertos < palabra.length() && cantErrores != MAX_ERR) {
			// Buscar letra en la palabra
			int posLetra = palabra.indexOf(letra.toUpperCase()); // Si letra !E = -1

			if (posLetra != -1) {
				letrasOk[posLetra] = true;
				cantAciertos++;
			} else {
				cantErrores++;
			}

			for (int i = 0; i < palabra.length(); i++) {
				// Si letraOK[true] -> mostrar letra correcta
				if (letrasOk[i]) {
					System.out.print(" " + palabra.charAt(i) + " ");
				} else {
					System.out.print(" _ ");
				}
			}

			System.out.println("    Llevas " + cantErrores + " errores");
			System.out.println();
			dibujar(cantErrores);

			if (cantAciertos < palabra.length() && cantErrores != MAX_ERR) {
				System.out.println("Escribe una letra (con tu teclado) para intentar adivinar");
				System.out.print("Letra: ");
				letra = sc.next();
				System.out.println();
			}
		}

		if (cantErrores == MAX_ERR) {
			System.out.println("¡Perdiste!");
			System.out.println("Vuelve a intentarlo");
			System.out.println();
		} else {
			dibujarGanar();
		}

		return cantErrores;
	}

	private static void dibujarGanar() {
		System.out.println("      _______");
		System.out.println("        |   |");
		System.out.println("            |");
		System.out.println("            |");
		System.out.println("   O        |");
		System.out.println("  (|)       |");
		System.out.println("  | | ______|___");
		System.out.println();
		System.out.println("¡Ganaste!");
		System.out.println("Tu premio fue este mensaje...");
		System.out.println();
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

		while (palabra.length() < MIN_PLBRA || palabra.length() > MAX_PLBRA) {
			System.out.println();
			System.out.println("¡Esa palabra es demasiado larga o corta para este sencillo juego!");
			System.out.println("Ingresa una palabra entre " + MIN_PLBRA + " y " + MAX_PLBRA + " letras.");
			System.out.println();
			System.out.print("Palabra: ");
			palabra = sc.next();
		}

		return palabra.toUpperCase();
	}

	private static void mostrarMensaje(String texto) {
		System.out.println("-----------------------------------");
		System.out.println(texto.toUpperCase());
		System.out.println("-----------------------------------");
		System.out.println();
	}
}
