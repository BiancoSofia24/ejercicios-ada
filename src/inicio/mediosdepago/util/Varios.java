package inicio.mediosdepago.util;

public class Varios {

	public static void showErr(String text) {
		System.out.println("- " + text.toUpperCase() + " -");
		System.out.println();
	}

	public static void showMessage(String text) {
		drawLine(text.length(), '*');
		System.out.println(text.toUpperCase());
		drawLine(text.length(), '*');
		System.out.println();
	}

	public static void drawLine(int size, char symbol) {
		for (int i = 0; i < size + 1; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}
}
