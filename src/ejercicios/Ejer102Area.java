package ejercicios;

import java.util.Scanner;

public class Ejer102Area {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Área de una paralelepipedo");
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("|\'");
		System.out.println("| \'");
		System.out.println("|  \'");
		System.out.println("|   \'");
		System.out.println("|    \'");
		System.out.println("|     \'");
		System.out.println("|      \'");
		System.out.println("|       \'");
		System.out.println("|        \'");
		System.out.println("|         \'");
		System.out.println("|          \'");
		System.out.println("|           \'");
		System.out.println("|            \'");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|             |");
		System.out.println("|_____________|");
		System.out.println();

		System.out.print("Lado A: ");
		int a = sc.nextInt();

		System.out.print("Lado B: ");
		int b = sc.nextInt();

		System.out.print("Lado C: ");
		int c = sc.nextInt();

		int h = a - c;
		int areaT = (h * b) / 2;
		int areaR = c * b;
		int areaTotal = areaT + areaR;

		System.out.println("El area del triángulo es: " + areaT);
		System.out.println("El area del rectángulo es: " + areaR);
		System.out.println("El area total es: " + areaTotal);

		sc.close();

	}
}
