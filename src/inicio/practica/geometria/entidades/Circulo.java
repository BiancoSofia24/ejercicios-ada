package inicio.practica.geometria.entidades;

public class Circulo extends Figuras implements Perimetrable, Nombrable {

	public double obtenerPerimetro() {
		// getLado = radio
		return (2 * Math.round(Math.PI) * getLado());
	}

	@Override
	public void nombrarFigura() {
		System.out.println("Circulo");
	}
}
