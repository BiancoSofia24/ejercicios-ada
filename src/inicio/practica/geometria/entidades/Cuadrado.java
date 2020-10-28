package inicio.practica.geometria.entidades;

public class Cuadrado extends Figuras implements Perimetrable, Nombrable {

	private int cantLados;

	public int getCantLados() {
		return cantLados;
	}

	public void setCantLados(int lados) {
		this.cantLados = lados;
	}

	@Override
	public double obtenerPerimetro() {
		double perimetro = cantLados * getLado();
		return perimetro;
	}

	@Override
	public void nombrarFigura() {
		System.out.println("Es un cuadrado");
	}

	// Lleva el método como default

}
