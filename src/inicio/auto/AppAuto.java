package inicio.auto;

public class AppAuto {

	/*
	 * Programar la clase auto que contenga: Tiene 5 velocidades y para hacer un
	 * cambio debo tener la velocidad adecuada. 0 -> cambio = 0 1-10 -> numeroCambio
	 * = 1 11-20 -> numeroCambio = 2 21-30 -> numeroCambio = 3 31-40 -> numeroCambio
	 * = 4 41+ -> numeroCambio = 5
	 * 
	 * int numeroCambio int velocidad
	 * 
	 * Programar getters y setters segun sea necesario Y los metodos acelerar,
	 * frenar segun sea posible validando las posibilidades y metodos subirCambio y
	 * bajarCambio
	 * 
	 * Proceso: subirCambio y luego acelerar validando la velocidad
	 * 
	 * 
	 */

	public static void main(String[] args) {

		showMessage("hola!");

		Auto auto = new Auto();

		System.out.println("Nombre del auto: Carrito");

		System.out.println("Velocidad incial: " + auto.getV());

		auto.subirCambio();
		auto.acelerar(5);
		auto.acelerar(25);
		auto.subirCambio();
		auto.acelerar(10);
		auto.bajarCambio();
		auto.frenar(10);

	}

	private static void showMessage(String text) {
		drawLine(text.length(), "-");
		System.out.println(text.toUpperCase());
		drawLine(text.length(), "-");
		System.out.println();
	}

	private static void drawLine(int size, String symbol) {
		for (int i = 0; i < size + 1; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
