package inicio.juego.entidades;

public class Revolver extends Arma implements Recargable, Ejecutable {

	private int cantBalas;

	public int getCantBalas() {
		return cantBalas;
	}

	public void setCantBalas(int cantBalas) {
		this.cantBalas = cantBalas;
	}

	public Revolver(int durabilidad, int danio) {
		super(durabilidad, danio);
	}

	@Override
	public int recargar(int cant) {
		this.cantBalas = cant;
		return cantBalas;
	}

	@Override
	public String toString() {
		return "Revolver. Cantidad de balas: " + cantBalas + " Daño: " + danio + " Durabilidad: " + durabilidad;
	}

	@Override
	public void disparar(int recarga) {
		this.cantBalas--;
	}

	@Override
	public String nombrar() {
		return "Revolver";
	}

}
