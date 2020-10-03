package inicio.auto;

public class Auto {

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

	private double v;
	private double cambio;

	public double acelerar(double a) {
		double nuevaV = v + a;
		if ((nuevaV / 10) == cambio - 1) {
			v = nuevaV;
			System.out.println("Acelerando. Velocidad actual: " + v + "km/h");
		} else {
			System.out.println("Esa velocidad no permite acelerar: v = " + a + "km/h");
		}
		return v;
	}

	public double frenar(double a) {
		double nuevaV = v - a;
		if ((nuevaV / 10) == cambio - 1) {
			v = nuevaV;
			System.out.println("Frenando. Velocidad actual: " + v + "km/h");

			if (v == 0) {
				System.out.println("Auto detenido");
			}
		} else {
			System.out.println("Esa velocidad no permite frenar: v = " + a + "km/h");
		}

		return v;

	}

	public void subirCambio() {
		this.cambio++;
		System.out.println("Cambio: " + cambio);
	}

	public void bajarCambio() {
		this.cambio--;
		System.out.println("Cambio: " + cambio);
	}

	public double getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public double getCambio() {
		return cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

}
