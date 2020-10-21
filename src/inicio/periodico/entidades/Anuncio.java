package inicio.periodico.entidades;

public class Anuncio extends Publicacion {

	private boolean tieneImg;
	private String empresa;
	private float precio;

	public Anuncio(int tamanio) {
		super(tamanio);
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isTieneImg() {
		return tieneImg;
	}

	public void setTieneImg(boolean tieneImg) {
		this.tieneImg = tieneImg;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	private static final float PRECIO_PORCIEN = 1.5f;

	public float calcularPrecio(int tamanio) {
		float importe = tamanio * PRECIO_PORCIEN;
		return importe;
	}

	@Override
	public boolean validar() {
		// validar algo (ej mayores de 18)
		return false;
	}

	@Override
	public String toString() {
		return "Anuncio con img: " + tieneImg;
	}

}
