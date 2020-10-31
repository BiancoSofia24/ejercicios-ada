package inicio.juego;

import inicio.juego.entidades.Arco;
import inicio.juego.entidades.Ejecutable;
import inicio.juego.entidades.Revolver;

public class AppJuego {

	public static void main(String[] args) {

		int durabilidad = 4;
		int danio = 2;

		Arco arco = new Arco(durabilidad, danio);
		int proyectiles = 0;
		int recarga = arco.recargar(proyectiles);
		String arma = arco.nombrar();
		String objetivo = "Zombie";
		System.out.println(arco);

		proyectiles = 12;
		recarga = arco.recargar(proyectiles);
		System.out.println("Encontraste " + recarga + " flechas!");
		System.out.println(arco);
		arco.ejecutar(arma, objetivo);
		arco.disparar(recarga);
		System.out.println(arco);
		arco.ejecutar(arma, objetivo);
		arco.disparar(recarga);
		System.out.println(arco);

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();

		durabilidad = 6;
		danio = 3;
		Revolver rev = new Revolver(durabilidad, danio);
		proyectiles = 0;
		recarga = arco.recargar(proyectiles);
		arma = rev.nombrar();
		System.out.println(rev);

		proyectiles = 6;
		recarga = rev.recargar(proyectiles);
		System.out.println("Encontraste " + recarga + " balas!");
		System.out.println(rev);
		rev.ejecutar(arma, objetivo);
		rev.disparar(recarga);
		System.out.println(rev);

		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();

		Ejecutable rev2 = new Revolver(durabilidad, danio);
		rev2.ejecutar(arma, objetivo);

	}

}
