package inicio.collection.callcenter;

public class Llamada {

	private int venta;
	private int reclamo;

	public Llamada(int venta, int reclamo) {
		this.venta = venta;
		this.reclamo = reclamo;
	}

	public int getVenta() {
		return venta;
	}

	public void setVentas(int venta) {
		this.venta = venta;
	}

	public int getReclamo() {
		return reclamo;
	}

	public void setReclamos(int reclamo) {
		this.reclamo = reclamo;
	}

	public String toString() {
		return "Ventas: " + venta + " Reclamos: " + reclamo;
	}

}
