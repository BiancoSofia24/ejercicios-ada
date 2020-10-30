package inicio.juego.entidades;

public class Arco extends Arma implements Recargable, Ejecutable {

	private int cantFlechas;

	public int getCantFlechas() {
		return cantFlechas;
	}

	public void setCantFlechas(int cantFlechas) {
		this.cantFlechas = cantFlechas;
	}

	public Arco(int durabilidad, int danio) {
		super(durabilidad, danio);
	}

	@Override
	public int recargar(int cant) {
		this.cantFlechas = cant;
		return cantFlechas;
	}

	@Override
	public String toString() {
		return "Arco. Cantidad de flechas: " + cantFlechas + " Daño: " + danio + " Durabilidad: " + durabilidad;
	}

	@Override
	public void disparar(int recarga) {
		this.cantFlechas--;
	}

	@Override
	public String nombrar() {
		return "Arco";
	}

}
