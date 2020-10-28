package inicio.practica.instrumentos;

public class Termometro extends Instrumento implements IntrumentoMedicion {

	public Termometro(float n, float v, float r) {
		super(n, v, r);
	}

	private float t;

	public float getT() {
		return t;
	}

	public void setT(float t) {
		this.t = t;
	}

	@Override
	public float medir(float p) {
		// PV = nRT
		t = (p * v) / (n * r);
		return t;
	}

}
