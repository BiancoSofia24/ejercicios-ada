package inicio.naipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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

			Map<String, List<Naipe>> mesa = new HashMap<String, List<Naipe>>();

			List<Naipe> mano;
			int j = 1;
			do {
				mano = new ArrayList<Naipe>();
				int opc = 0;
				int suma = 0;
				int valorAs = 0;
				System.out.println("Turno J" + j);
				do {
					Naipe cartaJ1 = mazo2.remove(0);
					mano.add(cartaJ1);

					if (cartaJ1.getNumCarta().getNombre() == "A") {
						System.out.println("Tiene un As. ¿Su As valdrá 1 u 11?");
						cartaJ1.getNumCarta().setValor(scan.nextInt());
					}

					suma += cartaJ1.getNumCarta().getValor();

					System.out.println("Jugador tiene: " + mano);
					System.out.println("Total actual: " + suma);

					System.out.println("¿Desea otra carta? (1 Sí / 2 No)");
					opc = scan.nextInt();

				} while (opc == 1);

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
					acc += naipeJ.getNumCarta().getValor();

					// if (naipeJ.getNumCarta().equals(NumCarta.AS)) {
					// int valorAs = NumCarta.AS.getValor() + NumCarta.DIEZ.getValor();
					// if (acc <= 10) {
					// acc += valorAs;
					// } else {
					// acc += NumCarta.AS.getValor();
					// }
					// } else {
					// acc += naipeJ.getNumCarta().getValor();
					// }

				}

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

			System.out.print("¿Jugar? ( 1 Si / 0 No) : ");
			instr = scan.nextInt();
		}

	}

	// Using LAMBDA and STREAM
	// public int calcularPrecioTotal() {
	// int precioTotal = this.precios.stream().mapToInt(precio ->
	// precio.intValue()).sum();
	// return precioTotal;
	// }

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
