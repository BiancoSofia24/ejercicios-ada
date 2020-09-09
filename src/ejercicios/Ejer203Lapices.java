package ejercicios;

import java.util.Scanner;

public class Ejer203Lapices {
	
		// Cantidad max
		// Precio nominal
		// Precio mayorista
	
	private static final int PRECIO_MIN = 90;
	private static final int PRECIO_MAY = 85;
	private static final int CANT_MAX = 1000;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido/a");
		
		System.out.println("Ingrese cantidad de lapices: ");
		int cant = sc.nextInt();
		
		sc.close(); 
		
		int precioL = 0;
		if (cant > 0 && cant < CANT_MAX) {
			
			precioL = PRECIO_MIN * cant;
			
		} else if (cant >= CANT_MAX) {
			
			precioL = PRECIO_MAY * cant;
			
		} else {
			
			System.out.println("Cantidad inválida");
			
		}
		
		System.out.println("El costo total es: $" + precioL);
		
	}
}

