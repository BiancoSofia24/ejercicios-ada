package inicio.practica.instrumentos;

import java.util.Scanner;

public class AppPractica {

	public static void main(String[] args) {
		System.out.println("hello world!");

		float n = 1; // Cant de moles en mol
		float v = 1; // Cant de volumen en L
		float r = 0.08206f; // Const L atm / mol K

		System.out.println("Segun una P obtener T. Ley de gas ideal");
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese presion en atm: ");
		float p = scan.nextFloat();
		Termometro termometro = new Termometro(n, v, r);
		System.out.println("La temperatura es: " + termometro.medir(p));

		System.out.println();
		System.out.println("Segun una T obtener P. Ley de gas ideal");
		System.out.print("Ingrese temperatura en K: ");
		float t = scan.nextFloat();

		Barometro bar = new Barometro(n, v, r);
		System.out.println("La temperatura es: " + bar.medir(t));

	}

}
