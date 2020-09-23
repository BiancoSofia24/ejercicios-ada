package ejercicios;

import java.util.Scanner;

/*
 * Se desea calcular el total de expensas a pagar de un edificio de 4 pisos que tiene 
 * un departamento por piso desde planta baja hasta el último piso. Se deben ingresar 
 * los valores de cada departamento y luego informar el importe de expensas promedio
 */

public class EjerExpDepto {

	private static final int CANT_DEPTOS = 4;

	public static void main(String[] args) {

		mostrarMensaje("conteo de expensas por departamento");
		float deptos[] = inicializarArray(CANT_DEPTOS);

		float totalExp = calcularTotal(deptos);
		imprimirResultados(totalExp);

	}

	private static void imprimirResultados(float totalExp) {
		System.out.println();
		System.out.println("El importe total de expensas es: " + totalExp);
		System.out.println("El importe promedio de expensas es: " + (totalExp / CANT_DEPTOS));
	}

	private static float calcularTotal(float[] deptos) {
		Scanner sc = new Scanner(System.in);
		float total = 0;
		for (int i = 0; i < deptos.length; i++) {
			System.out.print("Ingrese valor expensas del departamento " + (i + 1) + ": ");
			deptos[i] = sc.nextFloat();
			total += deptos[i];
		}
		return total;
	}

	private static float[] inicializarArray(int dimension) {
		float vector[] = new float[dimension];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
		}
		return vector;
	}

	private static void mostrarMensaje(String texto) {
		dibujarLinea(texto.length(), "-");
		System.out.println(texto.toUpperCase());
		dibujarLinea(texto.length(), "-");
		System.out.println();
	}

	private static void dibujarLinea(int tamanio, String simbol) {
		for (int i = 0; i < tamanio; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
