package inicio.resumenbancario.entidades;

// Las interface s�lo tienen m�todos nombrados, sin cuerpo
// S�lo definiciones de m�todos
public interface Precancelable {

	// void cancelar(String motivo);

	default void cancelar(String motivo) {
		System.out.println("Ha cancelado su servicio por: " + motivo);
	}
}
