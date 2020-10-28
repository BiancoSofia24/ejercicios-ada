package inicio.resumenbancario.entidades;

// Las interface sólo tienen métodos nombrados, sin cuerpo
// Sólo definiciones de métodos
public interface Precancelable {

	// void cancelar(String motivo);

	default void cancelar(String motivo) {
		System.out.println("Ha cancelado su servicio por: " + motivo);
	}
}
