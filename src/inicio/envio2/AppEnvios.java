package inicio.envio2;

import java.util.Scanner;

public class AppEnvios {

	private static final int CANT_ZONAS = 3;

	public static void main(String[] args) {

		System.out.println("Bienvenido/a...");
		mostrarTitulo("paquetitos: mi sistema de paquetería");
		System.out.println("                       ______ ");
		System.out.println("         __           |______|");
		System.out.println(" (>^^)> |__| <(^^<)   (^-.-'^)");
		System.out.println();

		System.out.println("Envíamos a las zonas 1, 2 y 3 (?)");

		int opcion = imprimirMenu();

		ejecutarMenu(opcion, CANT_ZONAS);
		System.out.println();

		System.out.println(" (u.u) ");
		System.out.println("Hasta luego...");
		mostrarTitulo("vuelva pronto");

	}

	private static int solicitarZona() {
		System.out.print("Indique zona de envio (1-3): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static int solicitarMonto() {
		System.out.print("Indique monto de la remesa (USD): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static float solicitarPeso() {
		System.out.print("Indique peso de su paquete / documento (Kg): ");
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}

	private static void calcularPrecio(int option) {

		System.out.println("Ingrese 0 para volver.");
		System.out.println();

		float envio;
		int zonaEnvio = solicitarZona();

		while (zonaEnvio != 0) {

			while (zonaEnvio < 0 || zonaEnvio > CANT_ZONAS) {
				showErr("opción erronea");
				zonaEnvio = solicitarZona();
			}

			if (option == 3) {
				// Remesas
				int cant = solicitarMonto();
				procesarRemesa(cant, zonaEnvio);
			} else {
				envio = solicitarPeso();

				while (envio <= 0) {
					showErr("opción erronea");
					envio = solicitarPeso();
				}

				switch (option) {
				case 1:
					// Cajas
					procesarCaja(envio, zonaEnvio);
					break;
				case 2:
					// Documentos
					procesarDoc(envio, zonaEnvio);
					break;
				}
			}

			zonaEnvio = solicitarZona();
		}
	}

	private static void procesarRemesa(int cantRemesa, int zonaEnvio) {
		Remesas remesa = Remesas.crearRemesa(cantRemesa);

		if (remesa.isTransportable(cantRemesa)) {
			float precioRemesa = remesa.calcularRemesa(cantRemesa, zonaEnvio);
			System.out.println();
			System.out.println("Costo de envío: " + remesa.conocerCostoRemesa(zonaEnvio) + " USD/gr");
			System.out.println("El valor del envío es: " + precioRemesa + " USD");
			System.out.println();
		} else {
			showErr("no podemos enviar esa cantidad de dinero");
			System.out.println();
		}
	}

	private static void procesarDoc(float pesoDoc, int zonaEnvio) {
		Documentos doc = Documentos.crearDoc(pesoDoc);

		if (doc.isTransportable(pesoDoc)) {
			float precioDoc = doc.calcularPrecio(pesoDoc, zonaEnvio);
			System.out.println();
			System.out.println("Costo de envío: " + doc.conocerCosto(zonaEnvio) + " USD/gr");
			System.out.println("El valor del envío es: " + precioDoc + " USD");
			System.out.println();
		} else {
			showErr("el documento es muy pesado. envíelo como paquete");
			System.out.println();
		}

	}

	private static void procesarCaja(float pesoCaja, int zonaEnvio) {
		Cajas paq = Cajas.crearCaja(pesoCaja);

		if (paq.isTransportable(pesoCaja)) {
			float precioCaja = paq.calcularPrecio(pesoCaja, zonaEnvio);
			System.out.println();
			System.out.println("Costo de envío: " + paq.conocerCosto(zonaEnvio) + " USD/gr");
			System.out.println("El valor del envío es: " + precioCaja + " USD");
			System.out.println();
		} else {
			showErr("el paquete es muy pesado");
			System.out.println();
		}

	}

	public static void ejecutarMenu(int opc, int cantOpc) {
		while (opc > 0) {
			if (opc > cantOpc) {
				showErr("opción erronea");
				opc = imprimirMenu();
			} else {
				switch (opc) {
				case 1:
					mostrarTitulo("Paquetes");

					System.out.println("          _____ ");
					System.out.println("      *  /    /| *");
					System.out.println("    * * /____/ / * *");
					System.out.println("  * * * |____|/  * * *");
					System.out.println("* * * *          * * * *");

					System.out.println("Peso máximo de 10Kg");

					calcularPrecio(opc);

					opc = imprimirMenu();
					break;
				case 2:
					mostrarTitulo("Documentos");

					System.out.println("      *  _____  * ");
					System.out.println("    * * |\\___/| * *");
					System.out.println("  * * * |_____| * * *");
					System.out.println("* * * *         * * * *");

					System.out.println("Peso máximo de 3Kg");

					calcularPrecio(opc);

					opc = imprimirMenu();
					break;
				case 3:
					mostrarTitulo("Remesas");

					System.out.println("    *  ===========  *");
					System.out.println("  * * |   ($$$)   | * *");
					System.out.println("* * *  ===========  * * *");

					System.out.println("Cantidad máxima de 1000 USD");

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

	private static void showErr(String text) {
		System.out.println();
		System.out.println("*** " + text.toUpperCase() + " ***");
	}

	private static void mostrarTitulo(String text) {
		drawLine(text.length(), "-");
		System.out.println(text.toUpperCase());
		drawLine(text.length(), "-");
		System.out.println();
	}

	private static void drawLine(int size, String symbol) {
		for (int i = 0; i < size + 1; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
