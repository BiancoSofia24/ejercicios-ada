package inicio.resumenbancario.entidades;

public class Prestamo extends ProductoBancario implements Precancelable {

	// Si existe un método default en una interface, se ejecuta 1ero si fue
	// sobreescrita
	@Override
	public void cancelar(String motivo) {
		System.out.println("Cancela prestamo por motivo: " + motivo);
	}

}
