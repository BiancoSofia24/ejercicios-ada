package inicio.periodico.entidades;

public abstract class Publicacion {

	private int tamanio;

	public Publicacion(int tamanio) {
		this.tamanio = tamanio;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public abstract boolean validar();

}
