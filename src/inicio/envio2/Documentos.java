package inicio.envio2;

public class Documentos extends Paquetes {

	private static float PESO_DOC = 3; // gr

	public boolean isTransportable(float carga) {
		return (carga <= PESO_DOC);
	}

	private Documentos(float peso) {
		super(peso);
	}

	public static Documentos crearDoc(float peso) {
		Documentos doc = new Documentos(peso);
		return doc;
	}
}
