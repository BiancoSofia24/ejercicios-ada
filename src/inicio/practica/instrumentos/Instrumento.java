package inicio.practica.instrumentos;

public class Instrumento {

	protected float r;
	protected float n;
	protected float v;

	public Instrumento(float n, float v, float r) {
		this.n = n;
		this.v = v;
		this.r = r;
	}

	public float getN() {
		return n;
	}

	public void setN(float n) {
		this.n = n;
	}

	public float getV() {
		return v;
	}

	public void setV(float v) {
		this.v = v;
	}

}
