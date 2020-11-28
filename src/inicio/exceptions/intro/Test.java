package inicio.exceptions.intro;

public class Test {

	public static void main(String[] args) {

		Object obj = metodoX();

		try {
			obj.toString();
		} catch (NullPointerException e) {
			// Runtime Exceptions (en tiempo de ejecucion) no checked excpetions
			System.out.println("Error " + e);
			System.out.println("El metodoX retorna NULL");
		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		int n = 0;
		int n2 = 4;

		try {
			System.out.println(n2 / n);
		} catch (ArithmeticException e) {
			System.out.println("Error " + e);
			System.out.println("Division por 0");
		}

	}

	private static Object metodoX() {
		return null;
	}
}
