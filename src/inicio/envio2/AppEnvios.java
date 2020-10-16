package inicio.envio2;

import java.util.Scanner;

public class AppEnvios {

	private static final int CANT_ZONAS = 3;

	public static void main(String[] args) {
		System.out.println("Bienvenido/a...");
		Utiles.mostrarTitulo("paquetitos: mi sistema de paquetería");
		Utiles.dibujar(1);

		System.out.println("Envíamos a Sur Ámerica (Zona 1) / Norte Ámerica (Zona 2) y Europa (Zona 3)");

		int opcion = imprimirMenu();

		ejecutarMenu(opcion, CANT_ZONAS);
		System.out.println();

		System.out.println("Hasta luego... (u.u)");
		Utiles.mostrarTitulo("vuelva pronto");
	}

	private static void calcularPrecio(int option) {
		System.out.println("Ingrese 0 para volver.");
		System.out.println();

		float envio;
		int zonaEnvio = solicitarZona();
		zonaEnvio = validarZona(zonaEnvio);

		while (zonaEnvio != 0) {
			switch (option) {
			case 1:
				// Cajas
				envio = Cajas.solicitarPeso();
				Cajas.procesarCaja(envio, zonaEnvio);
				break;
			case 2:
				// Documentos
				envio = Documentos.validarPeso();
				Documentos.procesarDoc(envio, zonaEnvio);
				break;
			case 3:
				// Remesas
				envio = Remesas.solicitarMonto();
				Remesas.procesarRemesa(envio, zonaEnvio);
				break;
			default:
				break;
			}

			zonaEnvio = solicitarZona();
			zonaEnvio = validarZona(zonaEnvio);
		}
	}

	private static int validarZona(int zonaEnvio) {
		while (zonaEnvio < 0 || zonaEnvio > CANT_ZONAS) {
			Utiles.showErr("zona inexistente");
			zonaEnvio = solicitarZona();
		}

		return zonaEnvio;
	}

	private static int solicitarZona() {
		System.out.print("Indique zona de envio (1-3): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static void ejecutarMenu(int opc, int cantOpc) {
		while (opc > 0) {
			if (opc > cantOpc) {
				Utiles.showErr("opción erronea");
				opc = imprimirMenu();
			} else {
				switch (opc) {
				case 1:
					Utiles.mostrarTitulo("paquetes");
					Utiles.dibujar(2);
					System.out.println("Peso máximo de 10Kg");

					calcularPrecio(opc);

					opc = imprimirMenu();
					break;
				case 2:
					Utiles.mostrarTitulo("documentos");
					Utiles.dibujar(3);
					System.out.println("Peso máximo de 3Kg");

					calcularPrecio(opc);

					opc = imprimirMenu();
					break;
				case 3:
					Utiles.mostrarTitulo("remesas");
					Utiles.dibujar(4);
					System.out.println("Cantidad mínima 100 USD, cantidad máxima de 1500 USD");

					calcularPrecio(opc);

					opc = imprimirMenu();
					break;
				}
			}
		}
	}

	public static int imprimirMenu() {
		System.out.println();
		System.out.println("Seleccione articulo a enviar: ");
		System.out.println("(1) -> Paquetes");
		System.out.println("(2) -> Documentos");
		System.out.println("(3) -> Remesas");
		System.out.println("(0) -> Salir");
		System.out.println();
		System.out.print("Opción: ");

		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		return option;
	}

}
