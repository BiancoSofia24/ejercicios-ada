package inicio.envio2;

public class Cajas extends Paquetes {

	private static float PESO_CAJA = 10000; // gr

	public boolean isTransportable(float carga) {
		return (carga <= PESO_CAJA);
	}

	private Cajas(float peso) {
		super(peso);
	}

	public static Cajas crearCaja(float peso) {
		Cajas caja = new Cajas(peso);
		return caja;
	}
}
