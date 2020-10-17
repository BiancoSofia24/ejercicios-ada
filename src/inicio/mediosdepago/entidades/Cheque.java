package inicio.mediosdepago.entidades;

public class Cheque extends MediosDePago {

	// Variables
	private String numero;
	private String empresa; // (?)
	private String banco;

	// Constructor
	public Cheque(float importe, String moneda, String numero) {
		super(importe, moneda);
		this.numero = numero;
	}

	// Getter / Setter
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	// Metodos
	// Sobreescribe el metodo abstracto de la superclase
	// implementando el metodo en cada subclase (definiendolo)
	@Override
	public boolean validar() {
		// verificar algo (numero)
		return false;
	}

}
