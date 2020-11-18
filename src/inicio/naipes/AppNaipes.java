package inicio.naipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Juego Blackjack (?)

// Genera baraja de naipes ingleses (52) 
// Repartir a 2 jugadores desnordenamente (Player 1, Player 2 o CPU)
// Una carta por jugador
// ¿Qué naipe le tocó a cada jugador? (Visualizar)

/*    			Class -> Mazo atributos -> LISTA cartas
 * 				Class -> Cartas (enumerada) (A, K, Q, J, 10...) atributos -> valor ( A = 11, K, Q, J = 10,..
 * 				Class enumerada -> Pintas (Picas, Diamantes, Treboles, Corazones)
 * 				Class -> Partida / Mano atributos -> LISTA cartas
 * 				Class -> Jugador (?)
 * 
 */

public class AppNaipes {

	public static void main(String[] args) {

		List<Naipe> mazo = new ArrayList<Naipe>();

		for (Pinta pinta : Pinta.values()) {
			for (NumCarta num : NumCarta.values()) {
				mazo.add(new Naipe(num, pinta));
			}
		}

		// View the deck
		// System.out.println(mazo);

		// Collections.shuffle(mazo);

		List<Naipe> mazo2 = barajear(mazo);

		// System.out.println(mazo2);

		Scanner scan = new Scanner(System.in);

		System.out.println("¿Jugar? ( 1 Si / 0 No) ");
		int instr = scan.nextInt();

		while (instr != 0) {

			System.out.print("Ingrese cantidad de jugadores: ");
			int jugadores = scan.nextInt();
			int[] array = new int[jugadores];
			for (int i = 0; i < array.length - 1; i++) {

				do {

					List<Naipe> mano = new ArrayList<Naipe>();
					int suma = 0;
					int opc;

					System.out.println("Turno J" + (i + 1));
					do {
						Naipe cartaJ1 = mazo2.remove(0);
						mano.add(cartaJ1);
						suma += cartaJ1.getNumCarta().getValor();

						System.out.println("Jugador tiene: " + mano);
						System.out.println("Suma " + suma);

						System.out.println("¿Desea otra carta? (1 Sí / 2 No)");
						opc = scan.nextInt();
					} while (opc == 1);

					array[i] = suma;
					System.out.println(array[i]);

					jugadores--;
				} while (jugadores > 0);
			}

			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}

			System.out.println("¿Jugar? ( 1 Si / 0 No) ");
			instr = scan.nextInt();
		}

		// Jugador 1
		/*
		 * List<Naipe> manoJ1 = new ArrayList<Naipe>(); int sumaJ1 = 0; int opc; do {
		 * Naipe cartaJ1 = mazo2.remove(0); manoJ1.add(cartaJ1); sumaJ1 +=
		 * cartaJ1.getNumCarta().getValor();
		 * 
		 * System.out.println("J1 tiene: " + manoJ1); System.out.println("Suma " +
		 * sumaJ1); System.out.println("¿Desea otra carta? (1 Sí / 2 No)"); opc =
		 * scan.nextInt(); } while (opc == 1);
		 * 
		 * // Jugador 2 List<Naipe> manoJ2 = new ArrayList<Naipe>(); int sumaJ2 = 0; opc
		 * = 0; do { Naipe cartaJ2 = mazo2.remove(0); manoJ2.add(cartaJ2); sumaJ2 +=
		 * cartaJ2.getNumCarta().getValor();
		 * 
		 * System.out.println("J2 tiene: " + manoJ2); System.out.println("Suma " +
		 * sumaJ2); System.out.println("¿Desea otra carta? (1 Sí / 2 No)"); opc =
		 * scan.nextInt(); } while (opc == 1);
		 * 
		 * // Comparar sumas de ambos jugadores definirGanador(sumaJ1, sumaJ2);
		 */

	}

	private static List<Naipe> barajear(List<Naipe> mazo) {
		List<Naipe> mazo2 = new ArrayList<Naipe>();
		Random random = new Random();

		while (!mazo.isEmpty()) {
			int rNaipe = random.nextInt(mazo.size());
			Naipe naipe = mazo.remove(rNaipe);
			mazo2.add(naipe);
		}

		return mazo2;
	}

	private static void definirGanador(int sumaJ1, int sumaJ2) {
		if (sumaJ1 <= 21 && sumaJ1 > sumaJ2) {
			System.out.println("J1 ganador");
		} else if (sumaJ2 <= 21 && sumaJ2 > sumaJ1) {
			System.out.println("J2 ganador");
		} else if (sumaJ1 == 21 || sumaJ2 == 21) {
			System.out.println("Blackjack!");
		} else if (sumaJ1 > 21 && sumaJ2 <= 21) {
			System.out.println("J2 ganador");
		} else if (sumaJ2 > 21 && sumaJ1 <= 21) {
			System.out.println("J1 ganador");
		} else if (sumaJ2 > 21 || sumaJ1 > 21) {
			System.out.println("Gana la casa :P");
		}

	}

}
