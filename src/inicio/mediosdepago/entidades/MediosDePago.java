package inicio.mediosdepago.entidades;

public class MediosDePago {

	public static int COD_EFECT = 1;
	public static int COD_TDC = 2;
	public static int COD_CHEQ = 3;

	private String moneda;
	private float importe;
	private int id;

	public MediosDePago(float importe, String moneda) {
		this.importe = importe;
		this.moneda = moneda;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

}
