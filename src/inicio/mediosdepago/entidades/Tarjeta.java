package inicio.mediosdepago.entidades;

public class Tarjeta extends MediosDePago {

	// Variables
	private String numero; // 0000 XXXX XXXX XXXX
	private String fechaVenc;
	private String nombre;
	private String codigo; // XXX
	private float interes; // porcentaje
	private float totalRecargo;

	// Constructor
	public Tarjeta(float importe, String moneda, String numero, String fechaVenc) {
		super(importe, moneda);
		this.numero = numero;
		this.fechaVenc = fechaVenc;
	}

	// Getter / Setter
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(String fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public float getTotalRecargo() {
		return totalRecargo;
	}

	public void setTotalRecargo(float totalRecargo) {
		this.totalRecargo = totalRecargo;
	}

	// Metodos
	@Override
	public boolean validar() {
		// verficiar algo (numero)
		return false;
	}

	// Si no agregamos este método al hacer un System.out.print de un obj tarjeta
	// Veremos en consola inicio.mediosdepago.entidades.Tarjeta@unNumero
	@Override
	public String toString() {
		return "Numero: " + numero + " Fecha de vencimiento: " + fechaVenc;
	}
}
