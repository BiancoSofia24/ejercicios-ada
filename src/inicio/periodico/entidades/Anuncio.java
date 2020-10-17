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

	private static final float PRECIO_BASE = 0.5f;

	public static float calcularPrecio(int tamanio) {
		float importe = tamanio * PRECIO_BASE;
		return importe;
	}

	@Override
	public boolean validar() {
		// validar algo (ej mayores de 18)
		return false;
	}

}
