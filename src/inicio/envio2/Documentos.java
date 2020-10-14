package inicio.envio2;

public class Documentos extends Paquetes {

	private static float PESO_DOC = 3; // Kg

	public boolean isTransportable(float pesoDoc) {
		return (pesoDoc > 0 && pesoDoc <= PESO_DOC);
	}

	private Documentos(float peso) {
		super(peso);
	}

	public static Documentos crearDoc(float peso) {
		return new Documentos(peso);
	}

	public static void procesarDoc(float pesoDoc, int zona) {
		Documentos doc = Documentos.crearDoc(pesoDoc);
		float precioDoc = doc.calcularPrecio(pesoDoc, zona);
		float costoZona = doc.conocerCosto(zona);
		String region = doc.definirZona(zona);

		if (doc.isTransportable(pesoDoc)) {
			Documentos.darRespuesta(precioDoc, costoZona, region);
		} else if (pesoDoc == 0) {
			Utiles.showErr("el documento no tiene peso");
			System.out.println();
		} else {
			Utiles.showErr("el documento es muy pesado. envíelo como paquete");
			System.out.println();
		}
	}

	public static void darRespuesta(float precioDoc, float costoZona, String region) {
		System.out.println();
		System.out.println("Costo de envío: " + costoZona + " USD/gr");
		System.out.println("El valor del envío a " + region + " es: " + precioDoc + " USD");
		System.out.println();
	}
}
