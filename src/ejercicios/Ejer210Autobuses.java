package ejercicios;

import java.util.Scanner;

public class Ejer210Autobuses {

	private static final int MIN_P = 20;
	private static final int COSTO_A = 2; 
	private static final float COSTO_B = 2.5f; // La f es para diferenciar que es de tipo float y no double
	private static final int COSTO_C = 3;
	private static final String BUS_A = "A";
	private static final String BUS_B = "B";
	private static final String BUS_C = "C";

	public static void main(String[] args) {
		
		/*
		 * Tres costos != por km p/cada autobus
		 * Mínimo 20 personas
		 * Costo total ?
		 * Costo p/persona ?
		 */
				
		System.out.println("Bienvenido/a");
		System.out.println();
		System.out.println("El mínimo de pasajeros es de 20.");
		
		// Solicitar cant personas
		Scanner sc = new Scanner(System.in); // creando un nuevo objeto. Instanciar: generar un nuevo objeto de la clase Scanner
		System.out.println("Ingrese cantidad de personas: ");
		int p = sc.nextInt(); // Personas (p) inicializado en el valor que ingrese el usuario. Valor que será de tipo int
		System.out.println();
		
		// Solitar cant km
		System.out.println("Ingrese cantidad de km: ");
		int km = sc.nextInt();
		System.out.println();
		
		// Solicitar tipo autobus
		System.out.println();
		System.out.println("Se ofrecen tres (3) modalidades de viaje.");
		System.out.println("El autobus 'A' tiene un valor: $" + COSTO_A + " por pasajero.");
		System.out.println("El autobus 'B' tiene un valor: $" + COSTO_B + " por pasajero.");
		System.out.println("El autobus 'C' tiene un valor: $" + COSTO_C + " por pasajero.");
		
		System.out.println("Ingrese tipo de autobus (A, B, C): ");
		String tipo = sc.next(); // El valor que ingresa el usuario es de tipo String
		
		sc.close(); // Debo cerrar el objeto creado, para que no quede esperando leer datos. Puedo cerrarlo cuando dejo de utilizarlo
		
		// Calcular costo transporte
		int totalP = MIN_P; // El mínimo de personas es 20
		if (p > MIN_P) {
			totalP = p;
		}
		
		// Calcular costo total
		// totalPersonas * km * precioBoleto
		int costoT = totalP * km;
		float total = 0;
		
		switch (tipo.toUpperCase()) { // toUpperCase() Compara siempre a mayúsculas
			case BUS_A: 
				total = costoT * COSTO_A;
				break;
			case BUS_B:
				total = costoT * COSTO_B;
				break;
			case BUS_C:
				total = costoT * COSTO_C;
				break;
		}
		
		System.out.println();
		System.out.println("El costo total es: $" + total);
		
		// Calcular costo p/persona ?
		float costoP = 0;
		costoP = total / totalP;
		System.out.println("El costo por persona es: $" + costoP);
		
	}
}
