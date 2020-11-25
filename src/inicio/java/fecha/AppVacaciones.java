package inicio.java.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Cargar la fecha de inicio de vacaciones de grupo empleados
// 5 empleados
// indicar cual empleado sale 1ero de vacaciones

public class AppVacaciones {

	private static final int EMPL_TEST = 3;
	private static final int CANT_EMPL = 5;

	public static void main(String[] args) {

		// calcularMayoriaEdad();

		// metodoUno();

		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("Metodo 2");
		System.out.println();

		Date[] fechasVacas = new Date[CANT_EMPL];
		SimpleDateFormat simpleDate2 = new SimpleDateFormat("ddMMyyyy");
		Scanner scan = new Scanner(System.in);

		System.out.println("Formato ingreso fecha ddMMyyyy");
		Date min = null;
		int pos = 0;
		for (int i = 0; i < CANT_EMPL; i++) {
			System.out.print("Ingrese fecha de vacaciones del empleado " + (i + 1) + ": ");
			String fecha = scan.next();

			// Las excepciones deben ser trabajadas con try-catch
			// Se puede usar throws en el método
			try {
				fechasVacas[i] = simpleDate2.parse(fecha);
				System.out.println("Fecha correcta");
			} catch (ParseException e) {
				// Checked exceptions. Try-catch o throws
				System.out.println("Error " + e);
				System.out.println("Error al ingresar una fecha en el formato indicado");
				System.out.println();
			} catch (Exception e) {
				// No es recomendable tener varias excepciones en una cadena de catch
				// Englobarlas es una mejor opcion
				System.out.println("Error: " + e);
			}

			// fechasVacas[i] = simpleDate2.parse(fecha);

			if (min == null || min.after(fechasVacas[i])) {
				min = fechasVacas[i];
				pos = i;
			}
		}

		System.out.println();
		System.out.println(
				"El empleado que saldrá antes de vaciones es: " + (pos + 1) + " en fecha: " + fechasVacas[pos]);

	}

	private static void calcularMayoriaEdad() throws ParseException {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sd = new SimpleDateFormat("ddMMyyyy");

		System.out.println("Mayoria de edad");

		System.out.println("1 Calcular mayoria de edad, 0 Saltar");
		int opc = scan.nextInt();
		boolean mayor;
		String fechaNacStr;
		Date fechaNac = new Date();

		while (opc != 0) {
			System.out.print("Ingrese su fecha de nac (Format ddMMyyyy): ");
			fechaNacStr = scan.next();

			fechaNac = sd.parse(fechaNacStr);
			mayor = esMayor(fechaNac);

			System.out.println("Es mayor? " + mayor);
			System.out.println();
			System.out.print("1 Calcular mayoria de edad, 0 Saltar: ");
			opc = scan.nextInt();
		}

	}

	private static void metodoUno() throws ParseException {
		System.out.println();
		System.out.println("Metodo 1. No recomendable");
		System.out.println();

		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scan = new Scanner(System.in);

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

	}

	private static boolean esMayor(Date fechaNac) {
		// Segun calendario fecha de actual
		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.YEAR, -18);
		return fechaNac.before(hoy.getTime());
	}

}
