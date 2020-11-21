package inicio.productos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *			Productos..... 100 productos (código númerico)
 *			Código secuencial (1..100) Precio (5...20)ARG 
 * 			Vender 10 productos (RANDOM) cantidad determinada (DEFAULT X CANTIDAD) 
 * 			PrecioTotal = ?
 */

public class AppProductos {

	private static final int MIN_PRECIO = 5;
	private static final int MAX_PRECIO = 20;
	private static final double CANTIDAD_MAX = 50;
	private static final int TOTAL_PRODUCTOS = 100;

	public static void main(String[] args) {

		List<Producto> listaProducto = generarListaProducto(TOTAL_PRODUCTOS);

		System.out.println("LISTA PRODUCTOS ORIGINAL");
		System.out.println("--------------------------------------");
		System.out.println(listaProducto);
		System.out.println();

		System.out.println("PRECIO TOTAL -> LISTA PRODUCTOS ORIGINAL");
		System.out.println("--------------------------------------");
		String precioTLista = calcularPrecioT(listaProducto);
		System.out.println("Precio TOTAL lista: " + precioTLista + " ARS");
		System.out.println();

		List<Venta> listaVentas = generarListaProductoAzar(listaProducto, 10);

		System.out.println("LISTA PRODUCTOS AZAR");
		System.out.println("--------------------------------------");
		listaVentas.forEach((elem) -> {
			System.out.println(elem);
		});
		System.out.println();

		System.out.println("PRECIO TOTAL -> LISTA PRODUCTOS AZAR");
		System.out.println("--------------------------------------");
		double total = 0;
		double precioTProducto = 0;
		for (Venta v : listaVentas) {
			precioTProducto = v.calcularPrecioT();
			total += precioTProducto;
		}
		System.out.println("Precio final venta: " + formatearDecimal(total) + " ARS");

	}

	private static List<Producto> generarListaProducto(int totalProductos) {
		List<Producto> listaProducto = new ArrayList<Producto>();
		Producto producto;
		double precio = 0;
		for (int i = 0; i < TOTAL_PRODUCTOS; i++) {
			precio = generarPrecio();
			producto = new Producto((i + 1), precio);
			listaProducto.add(producto);
		}
		return listaProducto;
	}

	private static List<Venta> generarListaProductoAzar(List<Producto> listaProducto, int cantidadProducto) {

		List<Venta> listaVentas = new ArrayList<Venta>();
		Venta venta;
		for (int i = 0; i < cantidadProducto; i++) {
			venta = new Venta(listaProducto.get(aleatorioEntero(TOTAL_PRODUCTOS)), aleatorioEntero(cantidadProducto));
			listaVentas.add(venta);
		}
		return listaVentas;
	}

	private static int aleatorioEntero(int valor) {
		Random random = new Random();
		return random.nextInt(valor);
	}

	private static double generarPrecio() {
		Random random = new Random();
		return MIN_PRECIO + (MAX_PRECIO - MIN_PRECIO) * random.nextDouble();
	}

	public static String calcularPrecioT(List<Producto> lista) {
		DecimalFormat formato = new DecimalFormat("#.##");
		double precioT = lista.stream().mapToDouble((elem) -> (elem.getPrecio() * CANTIDAD_MAX)).sum();
		return formato.format(precioT);
	}

	private static String formatearDecimal(double valorAFormatear) {
		DecimalFormat formato = new DecimalFormat("#.##");
		return formato.format(valorAFormatear);
		// numFormat = numFormat.replace(",", ".");
		// Double numFormatDouble = Double.parseDouble(numFormat);
	}

}
