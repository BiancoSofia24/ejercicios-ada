package inicio.resumenbancario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposito extends Movimiento {

	public Deposito(float importe, Date fecha) {
		super(importe, fecha);
	}

	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		return "Deposito. Fecha: " + sd.format(fecha) + " Importe: " + importe;
	}

}
