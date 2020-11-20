package inicio.naipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		// View deck
		// System.out.println(mazo);

		// Collections.shuffle(mazo);
		List<Naipe> mazo2 = barajear(mazo);
		// System.out.println(mazo2);

		Scanner scan = new Scanner(System.in);

		System.out.print("¿Jugar? ( 1 Si / 0 No) : ");
		int instr = scan.nextInt();
		while (instr != 0) {

			System.out.print("Ingrese cantidad de jugadores: ");
			int jugadores = scan.nextInt();

			// Profe
			Map<String, List<Naipe>> mesa = new HashMap<String, List<Naipe>>();

			List<Naipe> mano;
			int j = 1;
			do {
				mano = new ArrayList<Naipe>();
				int opc = 0;
				int suma = 0;
				System.out.println("Turno J" + j);
				do {
					Naipe cartaJ1 = mazo2.remove(0);
					mano.add(cartaJ1);

					/*
					 * if (cartaJ1.getNumCarta().getNombre() == "A") {
					 * System.out.println("Tiene un As. ¿Su As valdrá 1 u 11?");
					 * cartaJ1.getNumCarta().setValor(scan.nextInt()); }
					 */

					suma += cartaJ1.getNumCarta().getValor();

					// Desglosar la LIST=MANO del jugadore
					System.out.println("Jugador tiene: " + mano);
					System.out.println("Total actual: " + suma);

					System.out.println("¿Desea otra carta? (1 Sí / 2 No)");
					opc = scan.nextInt();

				} while (opc == 1);

				// Profe
				mesa.put("Jugador " + j, mano);
				j++;
				jugadores--;

			} while (jugadores > 0);

			System.out.println();
			System.out.println("RESULTADOS");
			System.out.println("----------");

			// Check what's inside "mesa" after playing
			mesa.forEach((jugador, manoJ) -> {
				System.out.println(jugador + ": ");
				int acc = 0;

				for (Naipe naipeJ : manoJ) {
					// System.out.println(naipeJ);
					// System.out.println("Valor Naipe: " + naipeJ.getNumCarta().getValor());
					// acc += naipeJ.getNumCarta().getValor();

					// Profe
					if (naipeJ.getNumCarta().equals(NumCarta.AS)) {
						int valorAs = NumCarta.AS.getValor() + NumCarta.DIEZ.getValor();
						if (acc <= 10) {
							acc += valorAs;
						} else {
							acc += NumCarta.AS.getValor();
						}
					} else {
						acc += naipeJ.getNumCarta().getValor();
					}

				}

				// System.out.println("Acumulado: " + acc);
				System.out.println("Total " + jugador + ": " + acc);
				System.out.println("-----------------------------");

				List<String> listaJugadores = new ArrayList<String>();
				listaJugadores.add(jugador);
				int[] totalJ = new int[listaJugadores.size()];
				for (int i = 0; i < listaJugadores.size(); i++) {
					totalJ[i] = acc;
					System.out.println(totalJ[i]);
				}

				System.out.println();
			});

			// Loop through MAP=MESA using WHILE
			/*
			 * Set<String> keys = mesa.keySet(); // Set of keys from the map
			 * Iterator<String> iterator = keys.iterator(); String key; List<Naipe> value;
			 * List<Integer> listaSumas = new ArrayList<Integer>(); while
			 * (iterator.hasNext()) { key = iterator.next(); // System.out.println(key +
			 * ": ");
			 * 
			 * value = mesa.get(key); int acc2 = 0; for (Naipe item : value) { //
			 * System.out.println(item); acc2 += item.getNumCarta().getValor(); }
			 * 
			 * // System.out.println("Acum: " + acc2); listaSumas.add(acc2); for (int i = 0;
			 * i < listaSumas.size(); i++) { // System.out.println(listaSumas.get(i)); if (i
			 * < listaSumas.size()) { // System.out.println("J" + (i + 1) + " suma " +
			 * listaSumas.get(i)); }
			 * 
			 * } }
			 */

			System.out.print("¿Jugar? ( 1 Si / 0 No) : ");
			instr = scan.nextInt();
		}

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

}
