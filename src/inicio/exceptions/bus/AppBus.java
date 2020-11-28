package inicio.exceptions.bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Venta de pasajes en bus con capacidad por bus 5 asientos (5 o más)
// Campos de venta: DNI pasajero, cantidad pasajes
// Un viaje por día y venta por día
// Al no haber más asientos informar, lanzar excepcion y intente reservar al siguiente día (mensaje)

// Map VIAJES fecha1 venta1 venta2
// Map Viajes fecha2

public class AppBus {

	private static final int TOTAL_ASIENTOS = 5;
	private static final String PATRON = "ddMMYYY";

	public static void main(String[] args) {
		System.out.println("Sistema de pasajes en bus");

		Scanner scan = new Scanner(System.in);
		// Bus bus = new Bus(TOTAL_ASIENTOS);
		List<Pasaje> ventas = new ArrayList<Pasaje>();
		Map<Date, List<Pasaje>> viajes = new HashMap<Date, List<Pasaje>>();

		System.out.print("Ingrese DNI pasajero (0 Salir): ");
		int dni = scan.nextInt();
		while (dni != 0) {

			System.out.print("Ingrese fecha de viaje (ddMMYYY): ");
			String fechaStr = scan.next();

			boolean disponibilidad = false;
			Pasaje pasaje = null;
			while (!disponibilidad) {
				System.out.print("Ingrese cantidad de pasajes: ");
				int cantidad = scan.nextInt();

				try {
					validarVenta(dni, cantidad, viajes, fechaStr);
					// imprimirFactura(pasaje);
					disponibilidad = true;

				} catch (MaxExcedidoException e) {
					System.out.println(e.getMessage());
					System.out.println("Intente nuevamente");
					System.out.println();

				} catch (SinDisponibilidadException e) {
					System.out.println("Intente comprar para la siguiente fecha de viaje");
					System.out.println();
					disponibilidad = true;

				} catch (ParseException e) {
					System.out.println("Fecha incorrecta");
				}
			}

			System.out.print("Ingrese DNI pasajero (0 Salir): ");
			dni = scan.nextInt();
		}

		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();
		System.out.println("Ventas por dia");
		viajes.forEach((key, value) -> {
			System.out.println(key);
			ventas.forEach((elem) -> System.out.println(elem));
		});

	}

	private static void validarVenta(int dni, int cantidad, Map<Date, List<Pasaje>> viajes, String fechaStr)
			throws MaxExcedidoException, SinDisponibilidadException, ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(PATRON);
		Date fecha = formatoFecha.parse(fechaStr);
		Pasaje pasaje = new Pasaje(dni, cantidad, fecha);
		List<Pasaje> pasajes = viajes.get(fecha) == null ? new ArrayList<Pasaje>() : viajes.get(fecha);
		Bus bus = new Bus(TOTAL_ASIENTOS);

		System.out.println(viajes.get(fecha));
		if (pasaje.getCantAsientos() <= bus.getAsiento()) {
			bus.setAsiento(bus.getAsiento() - pasaje.getCantAsientos());
			System.out.println(bus.getAsiento());
			pasajes.add(pasaje);
			viajes.put(fecha, pasajes);
		} else if (bus.getAsiento() == 0) {
			throw new SinDisponibilidadException();
		} else {
			throw new MaxExcedidoException("Número de pasajes excedido. Pasajes disponibles: " + bus.getAsiento());
		}

	}

	private static void imprimirFactura(Pasaje venta) {
		System.out.println();
		System.out.println("FACTURA");
		System.out.println(venta);
		System.out.println("¡Buen viaje!");
		System.out.println();
	}
}
