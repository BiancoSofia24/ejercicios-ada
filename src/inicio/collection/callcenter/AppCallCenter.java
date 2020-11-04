package inicio.collection.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Se desea conocer para cada uno de los dias del mes, la cantidad de ventas y de reclamos
// por dia que realizaron al call center en el mes
// Listar la informacion generada

// Llamadas -> Ventas o Reclamos
// días del mes -> 30 
// listar los datos (random sin bbdd)

public class AppCallCenter {

	public static void main(String[] args) {

		List<Llamada> calls = new ArrayList<Llamada>();
		Random randomVenta = new Random();
		Random randomReclamo = new Random();

		Llamada call;
		for (int i = 0; i < 30; i++) {
			int ventas = randomVenta.nextInt(100) + 1;
			int reclamos = randomReclamo.nextInt(200);

			call = new Llamada(ventas, reclamos);
			calls.add(call);
		}

		calls.forEach((el) -> {
			System.out.println(el);
		});
	}
}
