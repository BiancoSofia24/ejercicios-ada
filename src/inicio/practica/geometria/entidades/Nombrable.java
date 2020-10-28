package inicio.practica.geometria.entidades;

public interface Nombrable {

	void nombrarFigura();

	default boolean esFigura() {
		return true;
	}
}
