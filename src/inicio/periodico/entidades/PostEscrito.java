package inicio.periodico.entidades;

public class PostEscrito extends Post {

	private boolean tieneImg;
	private int cantPalabras;
	private String desc;

	public PostEscrito(int tamanio, String genero) {
		super(tamanio, genero);
	}

	public boolean isTieneImg() {
		return tieneImg;
	}

	public void setTieneImg(boolean img) {
		this.tieneImg = img;
	}

	public int getCantPalabras() {
		return cantPalabras;
	}

	public void setCantPalabras(int cantPalabras) {
		this.cantPalabras = cantPalabras;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
