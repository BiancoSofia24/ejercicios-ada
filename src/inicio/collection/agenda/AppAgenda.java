package inicio.collection.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// registrar agenda por dia
// se ingresan por teclado -> titulo actv y fecha
// una fecha varias actv
// mostrar actv por fecha

public class AppAgenda {

	public static void main(String[] args) throws ParseException {
		System.out.println("My toDo List");

		Map<Date, List<String>> toDo = new TreeMap<Date, List<String>>();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");

		Scanner scan = new Scanner(System.in);
		System.out.print("Ingresa la fecha en formato ddMMyyyy. (s/S) Salir: ");
		String fechaStr = scan.nextLine();

		Date fecha;
		String actv;
		while (!fechaStr.toLowerCase().equals("s")) {

			fecha = dateFormatter.parse(fechaStr);
			System.out.print("¿Qué vas a hacer? (s/S) Salir: ");
			actv = scan.nextLine();

			List<String> activities = toDo.get(fecha);

			if (activities == null) {
				activities = new ArrayList<String>();
			}

			activities.add(actv);
			toDo.put(fecha, activities);

			/*
			 * while (!actv.toLowerCase().equals("s")) { agenda.get(fecha).add(actv);
			 * System.out.println("Agregado!");
			 * System.out.print("¿Qué vas a hacer? (s/S) Salir: "); actv = scan.nextLine();
			 * }
			 */

			System.out.println();
			System.out.print("Ingresa la fecha en formato ddMMyyyy (s/S) Salir: ");
			fechaStr = scan.nextLine();
		}

		System.out.println();

		SimpleDateFormat dateFormatter2 = new SimpleDateFormat("dd/MM/yyyy");
		// Ordenar un array de String Collections.sort(listaString);
		toDo.forEach((k, v) -> {
			System.out.println(dateFormatter2.format(k) + ": ");
			for (String item : v) {
				System.out.println(item);
			}
			System.out.println();
		});

	}

}
