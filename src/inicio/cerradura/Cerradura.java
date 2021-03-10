package inicio.cerradura;

public class Cerradura {

	private Integer claveDeApertura;
	private Integer cantDeFallosBloqueo;
	private Integer clave;

	public Cerradura(Integer claveDeApertura, Integer cantDeFallosBloqueo) {
		this.claveDeApertura = claveDeApertura;
		this.cantDeFallosBloqueo = cantDeFallosBloqueo;
	}

	public Boolean abrir(Integer clave) {
		boolean abrir = false;
		if (cantDeFallosBloqueo != 0) {
			if (clave == claveDeApertura) {
				abrir = true;
			}
			cantDeFallosBloqueo--;
		}
		return abrir;
	}

	/*
	public void cerrar() {
			
	}
*/
	public Boolean estaAbierta() {
		boolean estaAbierta = abrir(clave);
		return estaAbierta;
	}

	public Boolean estaCerrada() {
		boolean estaCerrada = !abrir(clave);
		return estaCerrada;
	}

	/*
	public Boolean fueBloqueada() {

	}
*/
	public Integer contarAperturasExitosas() {
		Integer conteo = 0;
		if (estaAbierta() == true) {
			conteo++;
			return conteo;
		}
		return conteo;
	}

	public Integer contarAperturasFallidas() {
		Integer conteo = 0;
		if (estaCerrada() == true) {
			conteo++;
			return conteo;
		}
		return conteo;
	}


	public Integer getClaveDeApertura() {
		return this.claveDeApertura;
	}

	public void setClaveDeApertura(Integer claveDeApertura) {
		this.claveDeApertura = claveDeApertura;
	}

	public Integer getCantDeFallosBloqueo() {
		return this.cantDeFallosBloqueo;
	}

	public void setCantDeFallosBloqueo(Integer cantDeFallosBloqueo) {
		this.cantDeFallosBloqueo = cantDeFallosBloqueo;
	}

	public Integer getClave() {
		return this.clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

}
