package otrasClases;

public class Bicicleta {

	private int velocidad;
	private String color;

	/**
	 * Adiciona un valor a la velocidad actual
	 * 
	 * @param masVel
	 * @return velocidad
	 */
	public int acelerar(int masVel) {
		velocidad = masVel;
		return velocidad;
	}

	/**
	 * Disminuye la velocidad mientras el valor disminuido !> velocidad actual
	 * 
	 * @param menosVel
	 * @return velocidad
	 */
	public int frenar(int menosVel) {
		if (velocidad - menosVel >= 0) {
			velocidad = velocidad - menosVel;
		} else {
			System.out.println("La velocidad actual no permite frenar: v = " + menosVel);
		}

		return velocidad;
	}

	/**
	 * Lleva la velocidad a 0, cuando la velocidad actual < 5
	 * 
	 * @param velocidad
	 */
	public void detener() {
		if (velocidad < 5) {
			setVelocidad(velocidad);
		} else {
			System.out.println("No puedes frenar a esa velocidad");
		}
	}

	/**
	 * Getters y setters
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
