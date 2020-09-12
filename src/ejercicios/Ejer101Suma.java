package ejercicios;

import java.util.Scanner;

public class Ejer101Suma {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Suma");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("Ingrese 4 valores númericos");

		System.out.print("Primer valor: ");
		float n1 = sc.nextFloat();

		System.out.print("Segundo valor: ");
		float n2 = sc.nextFloat();

		System.out.print("Tercer valor: ");
		float n3 = sc.nextFloat();

		System.out.print("Cuarto valor: ");
		float n4 = sc.nextFloat();
		sc.close();

		float suma = n1 + n2 + n3 + n4;
		float prom = suma / 4;

		System.out.println("Resultado de la suma: " + suma);
		System.out.println("Resultado del promedio: " + prom);
	}
}
