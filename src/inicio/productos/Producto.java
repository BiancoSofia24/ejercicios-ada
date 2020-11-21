package inicio.productos;

public class Producto {

	private double precio;
	private int cod;

	public Producto(int cod, double precio) {
		this.cod = cod;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String toString() {
		return "Codigo: " + cod + " Precio: " + precio;
	}

}
