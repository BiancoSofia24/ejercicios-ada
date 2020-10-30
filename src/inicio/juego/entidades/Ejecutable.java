package inicio.juego.entidades;

public interface Ejecutable {

	default void ejecutar(String arma, String objetivo) {
		System.out.println("Usando " + arma + " contra " + objetivo);
	}
}
