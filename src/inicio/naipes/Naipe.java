package inicio.naipes;

public class Naipe {

	private Pinta pinta;
	private NumCarta valor;
	private String nombre;

	public Naipe(NumCarta valor, Pinta pinta) {
		this.valor = valor;
		this.pinta = pinta;
	}

	public Pinta getPinta() {
		return pinta;
	}

	public void setPinta(Pinta pinta) {
		this.pinta = pinta;
	}

	public NumCarta getNumCarta() {
		return valor;
	}

	public void setNumCarta(NumCarta valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return valor + " (" + pinta + ")";
	}

}
