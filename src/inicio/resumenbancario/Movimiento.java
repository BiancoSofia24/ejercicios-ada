package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimiento {

	protected float importe;
	protected Date fecha;

	public Movimiento(float importe, Date fecha) {
		this.importe = importe;
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		return "Mov fecha: " + sd.format(fecha) + " importe: " + importe;
	}

}
