package inicio.mediosdepago.entidades;

public class Efectivo extends MediosDePago {

	// Constructor
	public Efectivo(float importe, String moneda) {
		super(importe, moneda);
	}

	// Metodos
	@Override
	public boolean validar() {
		return false;
	}

}
