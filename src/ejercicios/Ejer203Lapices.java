package ejercicios;

import java.util.Scanner;

public class Ejer203Lapices {

	private static final int PRECIO_NOMINA = 90;
	private static final int PRECIO_MAYOR = 85;

	public static void main(String[] args) {
		
		// Cantidad max
		// Precio nominal
		// Precio mayorista
		
		/*
		 * Realice un algoritmo para determinar cu�nto se debe pagar por equis cantidad
			de l�pices considerando que si son 1000 o m�s el costo es de 85$; de lo contrario, el
			precio es de 90$. Repres�ntelo con el pseudoc�digo y el diagrama de flujo.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido/a");
		System.out.println("Ingrese cantidad de lapices: ");
		int cant = sc.nextInt();
		sc.close();
		
		int precioL = 0;
		if (cant > 0 && cant < 1000) {
			precioL = PRECIO_NOMINA * cant;
		} else if (cant >= 1000) {
			precioL = PRECIO_MAYOR * cant;
		} else {
			System.out.println("Cantidad inv�lida");
		}
		
		System.out.println("El costo total es: $" + precioL);
		
	}
}

