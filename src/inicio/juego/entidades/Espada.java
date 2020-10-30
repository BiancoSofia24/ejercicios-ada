package inicio.juego.entidades;

public class Espada extends Arma {

	public Espada(int durabilidad, int danio) {
		super(durabilidad, danio);
	}

	@Override
	public String nombrar() {
		return "Espada";
	}

	@Override
	public String toString() {
		return "Espada. Daño: " + danio + " Durabilidad: " + durabilidad;
	}

}
