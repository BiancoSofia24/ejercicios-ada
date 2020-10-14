package inicio.envio2;

import java.util.Scanner;

public class Remesas extends Paquetes {

	private static float PRECIO_REM_Z1 = 1.05f;
	private static float PRECIO_REM_Z2 = 1.1f;
	private static float PRECIO_REM_Z3 = 1.15f;
	private static float CANT_MAX = 1500; // USD
	private static float CANT_MIN = 100; // USD
	private float importe;

	private Remesas(int zona, float valor) {
		super(zona);
		this.importe = valor;
	}

	public float getCosto() {
		return importe;
	}

	public void setCosto(float valor) {
		this.importe = valor;
	}

	public boolean isTransportable(float cant) {
		return (cant >= CANT_MIN && cant <= CANT_MAX);
	}

	public static Remesas crearRemesa(int zona, float importe) {
		return new Remesas(zona, importe);
	}

	public float calcularRemesa(float importe, int zona) {
		float precio = 0;

		switch (zona) {
		case 1:
			precio = importe * PRECIO_REM_Z1;
			break;
		case 2:
			precio = importe * PRECIO_REM_Z2;
			break;
		case 3:
			precio = importe * PRECIO_REM_Z3;
			break;
		}

		return precio;
	}

	public float conocerCostoRemesa(int zona) {
		float costo = 0;

		switch (zona) {
		case 1:
			costo = PRECIO_REM_Z1;
			break;
		case 2:
			costo = PRECIO_REM_Z2;
			break;
		case 3:
			costo = PRECIO_REM_Z3;
			break;
		}

		return costo;
	}

	public static int solicitarMonto() {
		System.out.print("Indique monto de la remesa (USD): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static void procesarRemesa(float importe, int zonaEnvio) {
		Remesas remesa = Remesas.crearRemesa(zonaEnvio, importe);
		float precioRemesa = remesa.calcularRemesa(importe, zonaEnvio);
		float precioZona = remesa.conocerCostoRemesa(zonaEnvio);
		String region = remesa.definirZona(zonaEnvio);

		if (remesa.isTransportable(importe)) {
			Remesas.darRespuesta(precioRemesa, precioZona, region);
		} else if (importe == 0) {
			Utiles.showErr("no ingreso ningún importe");
			System.out.println();
		} else {
			Utiles.showErr("no podemos enviar esa cantidad de dinero");
			System.out.println();
		}
	}

	public static void darRespuesta(float precioRemesa, float precioZona, String region) {
		System.out.println();
		System.out.println("Costo de envío: " + precioZona + " USD/gr");
		System.out.println("El valor del envío a " + region + " es: " + precioRemesa + " USD");
		System.out.println();
	}

}