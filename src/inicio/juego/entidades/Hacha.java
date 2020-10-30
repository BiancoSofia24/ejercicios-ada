package inicio.juego.entidades;

public class Hacha extends Arma {

	public Hacha(int durabilidad, int danio) {
		super(durabilidad, danio);
	}

	@Override
	public String nombrar() {
		return "Hacha";
	}

	@Override
	public String toString() {
		return "Hacha. Daño: " + danio + " Durabilidad: " + durabilidad;
	}
}
