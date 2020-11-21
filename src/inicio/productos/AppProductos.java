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

	private static final int MIN = 5;
	private static final int MAX = 20;
	private static final double CANTIDAD_MAX = 50;

	public static void main(String[] args) {

		Random random = new Random();
		List<Producto> listaProducto = new ArrayList<Producto>();

		Producto producto;
		double precio = 0;
		for (int i = 0; i < 100; i++) {
			precio = MIN + (MAX - MIN) * random.nextDouble();
			precio = formatearDecimal(precio);
			producto = new Producto((i + 1), precio);

			listaProducto.add(producto);
		}

		System.out.println("LISTA PRODUCTOS ORIGINAL");
		System.out.println("--------------------------------------");
		System.out.println(listaProducto);
		System.out.println();

		System.out.println("PRECIO TOTAL -> LISTA PRODUCTOS ORIGINAL");
		System.out.println("--------------------------------------");
		double precioTLista = calcularPrecioT(listaProducto);
		System.out.println(precioTLista);

		List<Producto> listaProductoAzar = new ArrayList<Producto>();
		Producto productoAzar;
		int venta = 0;
		for (int i = 0; i < 10; i++) {
			venta = random.nextInt(100);
			productoAzar = listaProducto.get(venta);
			listaProductoAzar.add(productoAzar);
		}

		System.out.println("LISTA PRODUCTOS AZAR");
		System.out.println("--------------------------------------");
		System.out.println(listaProductoAzar);
		System.out.println();

		System.out.println("PRECIO TOTAL -> LISTA PRODUCTOS AZAR");
		System.out.println("--------------------------------------");
		double precioT = calcularPrecioT(listaProductoAzar);
		System.out.println(precioT);

	}

	public static double calcularPrecioT(List<Producto> lista) {
		double precioT = lista.stream().mapToDouble((elem) -> (elem.getPrecio() * CANTIDAD_MAX)).sum();
		return precioT;
	}

	private static double formatearDecimal(double precio) {
		DecimalFormat formato = new DecimalFormat("#.00");
		String numFormat = formato.format(precio);
		numFormat = numFormat.replace(",", ".");
		Double numFormatDouble = Double.parseDouble(numFormat);
		return numFormatDouble;
	}

}
