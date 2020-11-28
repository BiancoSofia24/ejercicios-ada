package inicio.exceptions.bus;

import java.util.Date;

public class Pasaje {

	private int idPasajero;
	private int cantAsientos;
	private Date fechaViaje;

	public Pasaje() {
	}

	public Pasaje(int idPasajero, int cantAsientos, Date fechaViaje) {
		this.idPasajero = idPasajero;
		this.cantAsientos = cantAsientos;
		this.fechaViaje = fechaViaje;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public int getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(int cantPasajes) {
		this.cantAsientos = cantPasajes;
	}

	public Date getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public String toString() {
		return String.format("DNI: %s PASAJES: %s", idPasajero, cantAsientos);
	}
}
