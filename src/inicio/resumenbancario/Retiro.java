package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Retiro extends Movimiento {

	public Retiro(float importe, Date fecha) {
		super(importe, fecha);
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		return "Reiro. Fecha: " + sd.format(fecha) + " Importe: -" + importe;
	}
}
