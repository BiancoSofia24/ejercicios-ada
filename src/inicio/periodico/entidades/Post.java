package inicio.periodico.entidades;

public class Post extends Publicacion {

	private String autor;
	private String genero;
	private String titulo;

	public Post(int tamanio, String genero) {
		super(tamanio);
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
	}

	@Override
	public boolean validar() {
		// validar algo
		return false;
	}

}
