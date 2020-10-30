package inicio.practica.geometria;

import inicio.practica.geometria.entidades.Circulo;
import inicio.practica.geometria.entidades.Cuadrado;
import inicio.practica.geometria.entidades.Pentagono;
import inicio.practica.geometria.entidades.Triangulo;

// Figuras: circulo, triangulo, cuadrado, pentagono
// Lados iguales en las figuras
// interface Perimetrable. Default de ser posible
// Generar instancia de cada clase e invocar el metodo

public class AppGeometria {

	public static void main(String[] args) {

		int largo = 4;

		Circulo circulo = new Circulo();
		circulo.setLado(largo);
		circulo.nombrarFigura();
		System.out.println("¿Es una figura? " + circulo.esFigura() + " Perimetro: " + circulo.obtenerPerimetro());

		Cuadrado cuad = new Cuadrado();
		int lados = 4;
		cuad.setLado(largo);
		cuad.setCantLados(lados);
		cuad.nombrarFigura();
		System.out.println("¿Es una figura? " + cuad.esFigura() + " Perimetro: " + cuad.obtenerPerimetro());

		Pentagono penta = new Pentagono();
		lados = 5;
		penta.setLado(largo);
		penta.setCantLados(lados);
		penta.nombrarFigura();
		System.out.println("¿Es una figura? " + penta.esFigura() + " Perimetro: " + penta.obtenerPerimetro());

		Triangulo triang = new Triangulo();
		lados = 3;
		triang.setLado(largo);
		triang.setCantLados(lados);
		triang.nombrarFigura();
		System.out.println("¿Es una figura? " + triang.esFigura() + " Perimetro: " + triang.obtenerPerimetro());

	}
}
