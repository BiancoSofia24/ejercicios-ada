package inicio.envio2;

public class Cajas extends Paquetes {

	private static float PESO_CAJA = 15; // Kg

	public boolean isTransportable(float pesoCaja) {
		return (pesoCaja > 0 && pesoCaja <= PESO_CAJA);
	}

	private Cajas(float peso, int zona) {
		super(peso, zona);
	}

	public static Cajas crearCaja(float peso, int zona) {
		return new Cajas(peso, zona);
	}

	public static void procesarCaja(float pesoCaja, int zona) {
		Cajas caja = Cajas.crearCaja(pesoCaja, zona);
		float precioCaja = caja.calcularPrecio(pesoCaja, zona);
		float costoZona = caja.conocerCosto(zona);
		String region = caja.definirZona(zona);

		if (caja.isTransportable(pesoCaja)) {
			Cajas.darRespuesta(precioCaja, costoZona, region);
		} else if (pesoCaja == 0) {
			Utiles.showErr("el paquete no tiene peso");
			System.out.println();
		} else {
			Utiles.showErr("el paquete es muy pesado");
			System.out.println();
		}
	}

	public static void darRespuesta(float precioCaja, float costoZona, String region) {
		System.out.println();
		System.out.println("Costo de envío: " + costoZona + " USD/gr");
		System.out.println("El valor del envío a " + region + " es: " + precioCaja + " USD");
		System.out.println();
	}
}
