package inicio.envio2;

public class Remesas extends Paquetes {

	private static float CANT_MAX = 1000; // USD
	private static float PRECIO_REM_Z1 = 1.05f;
	private static float PRECIO_REM_Z2 = 1.1f;
	private static float PRECIO_REM_Z3 = 1.15f;

	public boolean isTransportable(float cant) {
		return (cant <= CANT_MAX);
	}

	private Remesas(int cant) {
		super(cant);
	}

	public static Remesas crearRemesa(int cant) {
		Remesas remesa = new Remesas(cant);
		return remesa;
	}

	public float calcularRemesa(int cant, int zona) {

		float precio = 0;

		switch (zona) {
		case 1:
			precio = cant * PRECIO_REM_Z1;
			break;
		case 2:
			precio = cant * PRECIO_REM_Z2;
			break;
		case 3:
			precio = cant * PRECIO_REM_Z3;
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
}