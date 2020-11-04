package inicio.mediosdepago;

import java.util.Scanner;

import inicio.mediosdepago.entidades.Cheque;
import inicio.mediosdepago.entidades.Efectivo;
import inicio.mediosdepago.entidades.Tarjeta;
import inicio.mediosdepago.util.Varios;

// En el caso de que los cheques y las tarjetas 
// corresponden a bancos especificos yo podría crear una clase para bancos
// y asignarle algún tipo de identificador con el cual por ejemplo
// yo pueda comparar los 1eros 4 digitos de la tdc 
// y ver a que banco corresponde 

public class AppPagos {

	public static void main(String[] args) {
		float total[] = new float[3];
		Varios.showMessage("welcome to katzeapp!");
		System.out.println("Tu app de medios de pago :D");

		float importe = solicitarImporte();
		// importe = validarImporte(importe);

		int tipo;
		String moneda;
		String numero;
		while (importe != 0) {

			tipo = solicitarMedioPago();
			moneda = solicitarMoneda();

			switch (tipo) {
			case 1:
				Efectivo efect = new Efectivo(importe, moneda);
				total[0] += efect.getImporte();
				break;
			case 2:
				numero = solicitarTexto("numero de tarjeta: ");
				Tarjeta tarj = new Tarjeta(importe, moneda, numero, "10/12/2021");
				total[1] += tarj.getImporte();
				break;
			case 3:
				numero = solicitarTexto("numero de cheque: ");
				Cheque cheq = new Cheque(importe, moneda, numero);
				total[2] += cheq.getImporte();
				break;
			}

			System.out.println();
			importe = solicitarImporte();
			// importe = validarImporte(importe);
		}

		// Despedida
		System.out.println();
		// Varios.drawLine(60, '-');

		// mostrarTotales(total);

		Varios.showMessage("vuelve pronto!");

	}

	private static void mostrarTotales(float[] total) {
		System.out.println("Total importe efectivo: " + total[0]);
		System.out.println("Total importe tarjetas: " + total[1]);
		System.out.println("Total importe cheques: " + total[2]);
		System.out.println();
	}

	private static float validarImporte(float importe) {
		while (importe < 0) {
			Varios.showErr("no puedes ingresar montos menores a 0");
			importe = AppPagos.solicitarImporte();
		}

		return importe;
	}

	private static String solicitarTexto(String texto) {
		System.out.print("Ingrese " + texto);
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}

	private static String solicitarMoneda() {
		System.out.println("Tipos de moneda: ARS, USD, EUR");
		System.out.print("Ingrese moneda: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}

	private static int solicitarMedioPago() {
		System.out.println("Medios de pago: Efectivo -> 1, Tarjeta -> 2, Cheque -> 3");
		System.out.print("Ingrese medio de pago: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static float solicitarImporte() {
		System.out.print("Ingrese monto cancelado: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}

}
