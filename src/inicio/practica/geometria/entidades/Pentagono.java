package inicio.practica.geometria.entidades;

public class Pentagono extends Figuras implements Perimetrable, Nombrable {

	private int cantLados;

	public int getCantLados() {
		return cantLados;
	}

	public void setCantLados(int lados) {
		this.cantLados = lados;
	}

	@Override
	public void nombrarFigura() {
		System.out.println("Es un pentagono");
	}

	@Override
	public double obtenerPerimetro() {
		double perimetro = cantLados * getLado();
		return perimetro;
	}
}
