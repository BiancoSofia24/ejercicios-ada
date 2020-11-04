package inicio.collection.clima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppClima {

	public static void main(String[] args) {

		List<Medicion> mediciones = new ArrayList<Medicion>();
		Random randomSol = new Random();
		Random randomLluvia = new Random();

		Medicion medicion;
		for (int i = 0; i < 7; i++) {
			int temperatura = randomSol.nextInt(30);
			int lluvia = randomLluvia.nextInt(10);

			medicion = new Medicion(temperatura, lluvia);
			// System.out.println(medicion);
			mediciones.add(medicion);
		}

		System.out.println(mediciones);

		for (Medicion item : mediciones) {
			System.out.println(item);
		}

		// Lambda
		mediciones.forEach((el) -> {
			System.out.println(el);
		});
	}

}
