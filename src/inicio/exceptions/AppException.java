package inicio.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppException {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Producto> products = listarProductos();

		System.out.println("Sistema de Pedidos");
		System.out.println();

		try {

			System.out.print("Ingrese codigo producto: ");
			int id = scan.nextInt();
			System.out.print("Ingrese cantidad producto: ");
			int qtty = scan.nextInt();
			System.out.println();

			// Optional<Producto> product1 = buscarProducto(products, id);
			System.out.println("---------------------------------------------------");
			Producto product2 = buscarProducto2(products, id);

			validarStock(product2, qtty);
			imprimirFactura(product2, qtty);

		} catch (SinStockException e) {
			System.out.println(e.getMessage());

		} catch (ProductoNoEncontradoException e) {
			System.out.println("Producto no encontrado " + e.getMessage());
			System.out.println();
		}

		finally {
			// Bloque usado usualmente al trabajar con BBDD
			System.out.println("Bloque finally");
		}

	}

	private static void imprimirFactura(Producto product2, int qtty) {
		System.out.println("Factura Producto " + product2.getName());
		System.out.println("Código de Producto: " + product2.getId());
		System.out.println("Cantidad vendida: " + qtty);
	}

	private static void validarStock(Producto product2, int qtty)
			throws SinStockException, ProductoNoEncontradoException {
		if (product2 != null) {
			if (product2.getStock() >= qtty) {
				product2.setStock(product2.getStock() - qtty);
			} else {
				// Error
				throw new SinStockException("Sin stock. El stock actual es: " + product2.getStock());
			}
		} else {
			throw new ProductoNoEncontradoException();
		}

	}

	private static Producto buscarProducto2(List<Producto> products, int id) {
		boolean isFound = false;
		Producto product = null;
		int i = 0;
		while (!isFound && i < products.size()) {
			if (products.get(i).getId() == id) {
				isFound = true;
				product = products.get(i);
			}
			i++;
		}
		return product;
	}

	private static Optional<Producto> buscarProducto(List<Producto> productos, int id) {
		return productos.stream().filter((elem) -> elem.getId() == id).findAny();
	}

	private static List<Producto> listarProductos() {
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto(1, "Notebook", 10));
		productos.add(new Producto(2, "Mouse", 20));
		productos.add(new Producto(3, "Keyboard", 15));
		return productos;
	}

}
