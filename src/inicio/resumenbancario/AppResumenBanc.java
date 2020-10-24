package inicio.resumenbancario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
El resumen bancario del clinte tiene los últimos 4 mov de su cuenta
Los mov tienen fecha, importe y pueden ser retiros o depósitos
Se pide ingresar los movimientos y luego listarlos.
Vamos a listarlos ordenados de menor a mayor:
- Entre las fechas dadas.
- Todos.
*/

/*
 * 										Resumen
 * 	        Fecha      Importe        ( Accion       id      nombre       banco(?)       totalCuenta  )        
 * 
 * 		movimiento [1, 2, 3, 4]   -> mov 1 { fecha, importe }
 * 		
 * 
 * */

public class AppResumenBanc {

	private static final int CANT_MOV = 4;

	public static void main(String[] args) throws ParseException {

		System.out.println("Hello world!");

		Scanner scan = new Scanner(System.in);
		Movimiento[] movs = new Movimiento[CANT_MOV];

		for (int i = 0; i < CANT_MOV; i++) {

			Date fecha = solicitarFecha();
			float importe = solicitarImporte();

			System.out.print("Tipo de movimiento (1) Retiro (2) Deposito: ");
			int opc = scan.nextInt();
			if (opc == 1) {
				Retiro ret = new Retiro(importe, fecha);
				movs[i] = ret;
			} else {
				Deposito dep = new Deposito(importe, fecha);
				movs[i] = dep;
			}

			System.out.println();
		}

		imprimirDetalle(movs);

		/*
		 * Ordenamiento Burbuja int[] vector = { 15, 24, 7, 10 };
		 * 
		 * int aux = 0; for (int i = 0; i < vector.length - 1; i++) { for (int j = 0; j
		 * < vector.length - i - 1; j++) { if (vector[j + 1] < vector[j]) { aux =
		 * vector[j + 1]; vector[j + 1] = vector[j]; vector[j] = aux; } } }
		 * 
		 * for (int i = 0; i < vector.length; i++) { System.out.println("vector pos " +
		 * i + ": " + vector[i]); }
		 */

	}

	private static void imprimirDetalle(Movimiento[] movs) {
		// Ordenar fechas de menor a mayor
		Movimiento aux = null;
		for (int i = 0; i < movs.length - 1; i++) {
			for (int j = 0; j < movs.length - i - 1; j++) {
				// Para ordenar de mayor a menor usar after
				if (movs[j + 1].getFecha().before(movs[j].getFecha())) {
					aux = movs[j + 1];
					movs[j + 1] = movs[j];
					movs[j] = aux;
				}
			}
		}

		// Imprimir
		System.out.println();
		System.out.println("Detalle de movimientos por fecha");
		for (int i = 0; i < CANT_MOV; i++) {
			System.out.println(movs[i]);
		}

	}

	private static float solicitarImporte() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese importe del mov: ");
		return scan.nextFloat();
	}

	private static Date solicitarFecha() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese fecha del mov (formato ddMMyyyy): ");
		String fechaIngresada = scan.next();

		SimpleDateFormat sd = new SimpleDateFormat("ddMMyyyy");
		return sd.parse(fechaIngresada);
	}

}
