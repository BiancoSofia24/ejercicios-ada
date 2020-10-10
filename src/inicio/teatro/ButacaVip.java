package inicio.teatro;

// *
// La clase Butaca "extiende" sus atributos
public class ButacaVip extends Butaca {

	private boolean bebida;

	public ButacaVip(int posicion, boolean bebida) {
		// Con "super()" indicamos que utilizaremos
		// un constructor de la clase Butaca
		super(posicion);
		this.bebida = bebida;
	}

	public ButacaVip(int posicion) {
		super(posicion);
	}

	public boolean isBebida() {
		return bebida;
	}

	public void setBebida(boolean bebida) {
		this.bebida = bebida;
	}

	// Polimorfismo de getPrecio de la clase Butaca
	public float getPrecio() {
		if (bebida) {
			return precio * 1.5f;
		} else {
			return precio * 1.22f;
		}
	}
}
// *
