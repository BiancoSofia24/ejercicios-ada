package ejercicios;

import java.util.Scanner;

public class EjerCajasCobranza {

	public static void main(String[] args) {

		// Arrays Unidimensionales --> Tipo_Dato array[] = new Tipo_Dato[x]; x =
		// cantidad de elementos
		// array.length -> logitud del array

		float total = 0f;
		int cantFact = 0;
		float promedio = 0f;
		int cajas[] = new int[4];
		for (int i = 0; i < cajas.length; i++) {
			cajas[i] = 0;
		}

		// Definimos objeto scanner
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor ingrese su nombre");
		String nombre = sc.next();

		System.out.println("Bienvenido/a " + nombre);
		System.out.println("Ingresa el importe de su factura (0 para Salir)");
		float importe = sc.nextFloat();

		// Validación valor importe
		while (importe != 0) {
			System.out.println("Ingrese el número de caja a la que corresponde");
			int caja = sc.nextInt();

			// Validación número de caja
			while (caja > cajas.length) {
				System.out.println("Número de caja erroneo, ingrese nuevamente los datos.");
				System.out.println("Ingrese el número de caja a la que corresponde");
				caja = sc.nextInt();
			}

			if (caja >= 1 && caja <= cajas.length) {
				cajas[caja - 1] = cajas[caja - 1] + 1;
				total = total + importe;
			}

			System.out.println("Ingrese el importe de su factura (0 para Salir)");
			importe = sc.nextFloat();
		}

		// Cantidad de facturas por caja
		for (int i = 0; i < cajas.length; i++) {
			System.out.println("La caja " + (i + 1) + " tiene " + cajas[i] + " facturas");
			cantFact = cantFact + cajas[i];
		}

		System.out.println("Cantidad de facturas: " + cantFact);

		// Calculo del promedio de importes
		promedio = total / cantFact;

		System.out.println("Importe total: " + total);
		System.out.println("Importe promedio: " + promedio);

		sc.close();
	}

}
