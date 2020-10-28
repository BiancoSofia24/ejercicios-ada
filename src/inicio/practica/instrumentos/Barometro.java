package inicio.practica.instrumentos;

public class Barometro extends Instrumento implements IntrumentoMedicion {

	public Barometro(float n, float v, float r) {
		super(n, v, r);
	}

	private float p;

	public float getT() {
		return p;
	}

	public void setT(float p) {
		this.p = p;
	}

	@Override
	public float medir(float t) {
		// PV = nRT
		p = (n * r * t) / v;
		return p;
	}

}
