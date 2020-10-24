package inicio.expensas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Pago de exp entre el 1 y el 10 de cada mes
// A partir del 11 se cobra 1% interes
// Pedir fecha de pago e importe
// Calcular total a pagar

public class AppExpensas {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);

		Date diaPago = solicitarFechaPago();

		float pago = solicitarPago();

		long dif = difDias(diaPago);
		calcularRecargo(dif, pago);
	}

	private static void calcularRecargo(long dif, float pago) {
		float interes = dif * 0.01f;
		System.out.println("Recargo por mora = " + (interes * 100) + "%");
		float result = (pago * interes) + pago;
		System.out.println("El total a pagar es " + result);
	}

	private static float solicitarPago() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese el pago correpondiente: ");
		return scan.nextFloat();
	}

	private static Date solicitarFechaPago() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese fecha de pago (Formato ddMMyyyy): ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		return dateFormat.parse(scan.next());
	}

	private static long difDias(Date diaPago) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date diaCorte = dateFormat.parse("10102020");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(diaCorte);
		cal2.setTime(diaPago);
		return Duration.between(cal1.toInstant(), cal2.toInstant()).toDays();
	}
}
