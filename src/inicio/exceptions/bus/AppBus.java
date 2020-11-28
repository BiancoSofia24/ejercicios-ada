package inicio.exceptions.bus;

import java.util.InputMismatchException;
import java.util.Scanner;

// Venta de pasajes en bus con capacidad por bus 5 asientos (5 o más)
// Campos de venta: DNI pasajero, cantidad pasajes
// Un viaje por día y venta por día
// Al no haber más asientos informar, lanzar excepcion y intente reservar al siguiente día (mensaje)

public class AppBus {

	private static final int CANT_MAX_PASAJES = 5;

	public static void main(String[] args) {
		System.out.println("Sistema de pasajes en bus");

		Scanner scan = new Scanner(System.in);
		Bus bus = new Bus(CANT_MAX_PASAJES);

		System.out.print("¿Comprar? 1 Si - 0 No: ");
		int opc = scan.nextInt();
		while (opc != 0) {
			System.out.print("Ingrese DNI pasajero: ");
			int dni = scan.nextInt();

			boolean disponibilidad = false;
			Venta venta = null;
			while (!disponibilidad) {

				System.out.print("Ingrese cantidad de pasajes: ");
				int cantidad = scan.nextInt();

				try {
					venta = generarVenta(dni, cantidad);
					validarVenta(bus, venta);
					imprimirFactura(venta);
					disponibilidad = true;
				} catch (MaxExcedidoException e) {
					System.out.println(e.getMessage());
					System.out.println("Intente nuevamente");
					System.out.println();
				} catch (SinDisponibilidadException e) {
					System.out.println("Intente comprar para la siguiente fecha de viaje");
					System.out.println();
					disponibilidad = true;
				} catch (InputMismatchException e) {
					System.out.println("Error " + e);
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			System.out.print("¿Comprar? 1 Si - 0 No: ");
			opc = scan.nextInt();
		}

	}

	private static Venta generarVenta(int dni, int cantidad) {
		Venta venta = new Venta(dni, cantidad);
		return venta;
	}

	private static void validarVenta(Bus bus, Venta venta) throws MaxExcedidoException, SinDisponibilidadException {
		if (venta.getCantPasajes() <= bus.getAsiento()) {
			bus.setAsiento(bus.getAsiento() - venta.getCantPasajes());
		} else if (bus.getAsiento() == 0) {
			throw new SinDisponibilidadException();
		} else {
			throw new MaxExcedidoException("Número de pasajes excedido. Pasajes disponibles: " + bus.getAsiento());
		}

	}

	private static void imprimirFactura(Venta venta) {
		System.out.println();
		System.out.println("FACTURA");
		System.out.println(venta);
		System.out.println("¡Buen viaje!");
	}
}
