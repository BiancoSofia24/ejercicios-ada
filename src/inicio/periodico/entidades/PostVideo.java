package inicio.periodico.entidades;

public class PostVideo extends Post {

	private int duracion;
	private String resolucion;

	public PostVideo(int tamanio, String genero) {
		super(tamanio, genero);
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

}
