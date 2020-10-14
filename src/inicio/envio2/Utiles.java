package inicio.envio2;

public class Utiles {

	public static void dibujar(int opc) {
		switch (opc) {
		case 1:
			System.out.println("                       ______ ");
			System.out.println("         __           |______|");
			System.out.println(" (>^^)> |__| <(^^<)   (^-.-'^)");
			System.out.println();
			break;
		case 2:
			System.out.println("          _____ ");
			System.out.println("      *  /    /| *");
			System.out.println("    * * /____/ / * *");
			System.out.println("  * * * |____|/  * * *");
			System.out.println("* * * *          * * * *");
			break;
		case 3:
			System.out.println("      *  _____  * ");
			System.out.println("    * * |\\___/| * *");
			System.out.println("  * * * |_____| * * *");
			System.out.println("* * * *         * * * *");
			break;
		case 4:
			System.out.println("    *  ===========  *");
			System.out.println("  * * |   ($$$)   | * *");
			System.out.println("* * *  ===========  * * *");
			break;
		}
	}

	public static void showErr(String text) {
		System.out.println();
		System.out.println("*** " + text.toUpperCase() + " ***");
	}

	public static void mostrarTitulo(String text) {
		drawLine(text.length(), "-");
		System.out.println(text.toUpperCase());
		drawLine(text.length(), "-");
	}

	public static void drawLine(int size, String symbol) {
		for (int i = 0; i < size + 1; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
