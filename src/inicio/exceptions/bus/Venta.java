package inicio.exceptions.bus;

public class Venta {

	private int idPasajero;
	private int cantPasajes;

	public Venta() {
	}

	public Venta(int idPasajero, int cantPasajes) {
		this.idPasajero = idPasajero;
		this.cantPasajes = cantPasajes;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public int getCantPasajes() {
		return cantPasajes;
	}

	public void setCantPasajes(int cantPasajes) {
		this.cantPasajes = cantPasajes;
	}

	public String toString() {
		return String.format("DNI: %s PASAJES: %s", idPasajero, cantPasajes);
	}
}
