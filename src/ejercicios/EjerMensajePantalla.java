package ejercicios;

/*
 * 	============================================================
 * 	|                                                          |
 *	|                                                          |
 * 	|                                                          |
 * 	|                       Hola mundo                         |
 * 	|                                                          |
 * 	|                                                          |
 * 	|                                                          |
 * 	|                                                          |
 * 	============================================================
 */

public class EjerMensajePantalla {

	public static void main(String[] args) {

		int ancho = 50;
		int alto = 13; // Valor impar para optimizar centrado
		String mensaje = "Hola, es es un mensaje";

		mostrarMensaje("saludo");

		dibujarPantalla(mensaje, ancho, alto, '*');
	}

	private static void dibujarPantalla(String mensaje, int ancho, int alto, char simb) {

		int textoY = (alto - 1) / 2;
		int textoX = ancho - mensaje.length();
		int margen = textoX / 2;

		// i -> filas / j -> columnas
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				if (i == 0 || i == alto - 1) {
					System.out.print(simb);
				} else if (j == 0 || j == ancho - 1) {
					System.out.print(simb);
				} else if (i == textoY && j == margen) {
					System.out.print(mensaje);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

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
