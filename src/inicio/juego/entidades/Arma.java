package inicio.juego.entidades;

public abstract class Arma {

	protected int durabilidad;
	protected int danio;

	public Arma(int durabilidad, int danio) {
		this.durabilidad = durabilidad;
		this.danio = danio;
	}

	public int getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public abstract String nombrar();

}
