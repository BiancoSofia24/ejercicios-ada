package inicio.periodico;

import java.util.Scanner;

import inicio.periodico.entidades.Anuncio;
import inicio.periodico.util.Varios;

// publicaciones = notas ( escritas / video ) / publicidad
// portal con 10 publicaciones online
// publicaciones se cobrar segun tamaño en pantalla
// notas [ autor, seccion ]
// clases / atributos / totalFacturado

public class AppPeriodico {

	private static int PUBLIC_T = 10;

	public static void main(String[] args) {

		Varios.showMessage("bienvenido a portalcito web");

		Object[] publicaciones = new Object[PUBLIC_T];
		float total = 0;

		for (int i = 0; i < PUBLIC_T; i++) {

			int opc = solicitarOpc("publicidad");
			switch (opc) {
			case 1:
				int tipoPost = solicitarOpc("post 1 Escrito / 2 Video: ");
				break;
			case 2:
				Anuncio anuncio = new Anuncio(200);
				publicaciones[i] = anuncio;
				break;
			default:
				Varios.showErr("opcion erronea");
			}
		}

		for (int i = 0; i < PUBLIC_T; i++) {
			if (publicaciones[i] instanceof Anuncio) {
				Anuncio aux = (Anuncio) publicaciones[i];
				// total += aux;
			}
		}

		/*
		 * int opc =
		 * solicitarOpcion("publicación Post (1) / Anuncio (2) / Salir (0): "); opc =
		 * validarInstr(opc);
		 * 
		 * int acc = 0; while (opc != 0 && acc < PUBLIC_T) {
		 * 
		 * switch (opc) { case 1: int tipoPost =
		 * solicitarOpcion("post Escrito (1) / Video (2) / Volver (0): ");
		 * procesarPost(tipoPost); break; case 2:
		 * System.out.println("Su publicacion es un anuncio"); Anuncio anuncio = new
		 * Anuncio(200); break; default: Varios.showErr("opcion erronea"); }
		 * 
		 * acc++; if (acc < 10) { System.out.println(); opc =
		 * solicitarOpcion("publicación Post (1) / Anuncio (2) / Salir (0): "); // tipo
		 * = validarInstr(tipo); } else {
		 * Varios.showErr("ha alcanzado el maximo de publicaciones"); } }
		 */

	}

	/*
	 * private static void procesarPost(int opc) { switch (opc) { case 1:
	 * System.out.println("Post escrito");
	 * 
	 * PostEscrito pEsc = new PostEscrito(200, "economia"); break; case 2:
	 * System.out.println("Post en video"); PostVideo pVid = new PostVideo(500,
	 * "turismo"); break; default: Varios.showErr("opcion erronea"); } }
	 * 
	 * private static int validarInstr(int opc) { while (opc < 0 || opc > 2) {
	 * Varios.showErr("opcion erronea"); System.out.print("Ingrese nuevamente: ");
	 * Scanner scan = new Scanner(System.in); opc = scan.nextInt(); } return opc; }
	 */

	private static int solicitarOpc(String tipo) {
		System.out.print("Elija tipo de " + tipo);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

}
