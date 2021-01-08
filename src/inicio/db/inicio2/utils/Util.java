package inicio.db.inicio2.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	private static final int MAX_CHAR = 50;
	private static final int MIN_CHAR = 1;

	public static String valueForNullString(String text) {
		if (text == null) {
			return "none";
		}
		return text;
	}

	public static boolean isValidStringLength(String text) {
		boolean notValid = text.length() < MIN_CHAR || text.length() > MAX_CHAR;
		return notValid;
	}

	// Doesn't work. Idk
	public static void isValidEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.find() == true) {
			System.out.println("El email ingresado es válido.");
		} else {
			System.out.println("El email ingresado es inválido.");
		}
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
