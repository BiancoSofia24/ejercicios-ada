package inicio.java.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Cargar la fecha de inicio de vacaciones de grupo empleados
// 5 empleados
// indicar cual empleado sale 1ero de vacaciones

public class AppVacaciones {

	private static final int EMPL_TEST = 3;
	private static final int CANT_EMPL = 5;

	public static void main(String[] args) throws ParseException {

		System.out.println("Metodo 1. No recomendable");

		Scanner scan = new Scanner(System.in);

		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

		Date[] fechas = new Date[EMPL_TEST];
		String[] fechasStr = new String[EMPL_TEST];
		Date hoy = new Date();

		long[] difEntreFechas = new long[EMPL_TEST];

		System.out.println("Formato ingreso fecha yyyy-MM-dd");
		for (int i = 0; i < EMPL_TEST; i++) {
			// Ingresar fechas
			System.out.print("Ingrese fecha de vacaciones del empleado " + (i + 1) + ": ");
			fechasStr[i] = scan.next();
			System.out.println();

			// De String a obj Date. Formatear fechas
			fechas[i] = simpleDate.parse(fechasStr[i]);

			// Obtener miliseg para comparar con fecha actual
			difEntreFechas[i] = (fechas[i].getTime() - hoy.getTime());

		}

		// Indicar que fecha es la más cercana (según los miliseg) e imprimir su
		// posicion
		long menorDif = difEntreFechas[0];
		int pos = 0;
		for (int i = 0; i < EMPL_TEST; i++) {
			if (difEntreFechas[i] < menorDif) {
				menorDif = difEntreFechas[i];
				pos = i;
			}
		}

		System.out.println("El empleado que saldrá antes de vaciones es: " + (pos + 1) + " en fecha: " + fechas[pos]);

		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("Metodo 2");
		System.out.println();

		Date[] fechasVacas = new Date[CANT_EMPL];
		SimpleDateFormat simpleDate2 = new SimpleDateFormat("ddMMyyyy");

		Date min = null;
		pos = 0;

		System.out.println("Formato ingreso fecha ddMMyyyy");
		for (int i = 0; i < CANT_EMPL; i++) {
			System.out.print("Ingrese fecha de vacaciones del empleado " + (i + 1) + ": ");
			String fecha = scan.next();
			fechasVacas[i] = simpleDate2.parse(fecha);

			if (min == null || min.after(fechasVacas[i])) {
				min = fechasVacas[i];
				pos = i;
			}
		}

		System.out.println();
		System.out.println(
				"El empleado que saldrá antes de vaciones es: " + (pos + 1) + " en fecha: " + fechasVacas[pos]);

	}

}
