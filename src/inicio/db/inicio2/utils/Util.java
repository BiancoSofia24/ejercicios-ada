package inicio.db.inicio2.utils;

public class Util {

	private static final int MAX_CHAR = 50;
	private static final int MIN_CHAR = 1;

	public static String valueForNullString(String text) {
		if (text == null) {
			return "none";
		}
		return text;
	}

	public static boolean validateStringLength(String text) {
		boolean notValid = text.length() < MIN_CHAR || text.length() > MAX_CHAR;
		return notValid;
	}

	public static void showError(String text) {
		System.out.println(" *** " + text + " *** ");
	}

	public static void showSubtitle(String text) {
		System.out.println();
		System.out.println(text);
		System.out.println("-------------------------------------");
	}

	public static void showTitle(String text) {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println(text);
		System.out.println("-------------------------------------");
	}
}
