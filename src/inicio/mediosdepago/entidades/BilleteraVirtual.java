package inicio.mediosdepago.entidades;

public class BilleteraVirtual extends MediosDePago {

	public BilleteraVirtual(float importe, String moneda) {
		super(importe, moneda);
	}

	@Override
	public boolean validar() {
		// verificar algo (usuario)
		return false;
	}

}
