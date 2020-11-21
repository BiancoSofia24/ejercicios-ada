package inicio.productos;

import java.text.DecimalFormat;

public class Venta {

	private Producto producto;
	private int cantidad;

	public Venta(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double calcularPrecioT() {
		double precioT = this.producto.getPrecio() * this.cantidad;
		return precioT;
	}

	public String toString() {
		DecimalFormat formato = new DecimalFormat("#.00");
		return String.format("Producto: %s Cantidad: %s Precio/producto: %s", producto, cantidad,
				formato.format(calcularPrecioT()));
	}
}
