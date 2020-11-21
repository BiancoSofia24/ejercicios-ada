package inicio.productos;

import java.text.DecimalFormat;

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
		DecimalFormat formato = new DecimalFormat("#.00");
		return String.format("{Código: %s Precio: %s ARS}", cod, formato.format(precio));
	}

}
