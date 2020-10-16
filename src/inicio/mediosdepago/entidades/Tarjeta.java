package inicio.mediosdepago.entidades;

public class Tarjeta extends MediosDePago {

	private String numero; // 0000 XXXX XXXX XXXX
	private String fechaVenc;
	private String nombre;
	private String codigo; // XXX
	private float interes; // porcentaje
	private float totalRecargo;

	public Tarjeta(float importe, String moneda, String numero) {
		super(importe, moneda);
		this.numero = numero;
	}

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

}
