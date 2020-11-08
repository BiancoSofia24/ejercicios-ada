package inicio.collection.ensamblado;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// Armado de productos -> partes / código númerico
// Ingreso por teclado del código y lista de partes asociadas a ese producto
// Listar productos ordenados por código

public class AppEnsamblado {

	public static void main(String[] args) {

		System.out.println("AppEnsamblado");

		Scanner scan = new Scanner(System.in);
		Map<Integer, List<String>> products = new TreeMap<Integer, List<String>>();

		System.out.print("Ingrese código de producto (0 Salir): ");
		// int code = scan.nextInt();
		String codeStr = scan.nextLine();
		Integer codeInt = Integer.parseInt(codeStr);

		String elem;
		List<String> elements;
		while (codeInt != 0) {

			System.out.println("Ingrese nombre del elemento: ");
			elem = scan.nextLine();

			elements = products.get(codeInt);
			if (elements == null) {
				elements = new ArrayList<String>();
			}

			elements.add(elem);
			products.put(codeInt, elements);

			System.out.println();
			System.out.print("Ingrese código de producto (0 Salir): ");
			// code = scan.nextInt();
			codeStr = scan.nextLine();
			codeInt = Integer.parseInt(codeStr);
		}

		products.forEach((k, v) -> {
			System.out.println("Producto: " + k + " Partes: ");
			for (String item : v) {
				System.out.println(item);
			}
			System.out.println();
		});
	}
}
