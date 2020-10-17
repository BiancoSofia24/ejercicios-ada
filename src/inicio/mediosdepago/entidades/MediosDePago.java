package inicio.mediosdepago.entidades;

// Clase abstracta, dado que no referencia a un objeto concreto son genericas
// Estás clases agrupan cosas comunes y evitan que el desarrollador las utilice
public abstract class MediosDePago {

	// Variables
	public static int COD_EFECT = 1;
	public static int COD_TDC = 2;
	public static int COD_CHEQ = 3;

	private String moneda;
	private float importe;
	private int id;

	// Constructor
	public MediosDePago(float importe, String moneda) {
		this.importe = importe;
		this.moneda = moneda;
	}

	// Getter / Setter
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

	// Metodos
	// Metodo abstracto es generado solo en una clase abstracta
	// Se definen public abstract boolean methodName();
	public abstract boolean validar();
}
