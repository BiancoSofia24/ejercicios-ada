package inicio.collection.inicial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import inicio.mediosdepago.entidades.Tarjeta;

public class AppCollection {

	public static void main(String[] args) {

		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		Tarjeta tdc1 = new Tarjeta(500, "ARS", "4141", "10/12/2021");
		Tarjeta tdc2 = new Tarjeta(250, "ARS", "4949", "10/12/2021");
		tarjetas.add(tdc1);
		tarjetas.add(tdc2);
		System.out.println(tarjetas);

		System.out.println();

		listsTest();

		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();

		setTest();

	}

	private static void setTest() {
		Set<String> set = new HashSet<String>();
		System.out.println("size: " + set.size()); // 0

		set.add("20-0000");
		set.add("20-0001");
		System.out.println("size: " + set.size()); // 2
		// Repeat info
		set.add("20-0001");
		// The size don´t change
		System.out.println("size: " + set.size()); // 2

		System.out.println();
		System.out.println("Loop with Iterator...");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println();
		System.out.println("Loop with forEach...");
		set.forEach((el) -> {
			System.out.println(el);
		});

	}

	private static void listsTest() {
		String nombre1 = "elem 1";

		List<String> list = new ArrayList<String>();
		System.out.println("size: " + list.size()); // 0

		list.add(nombre1);
		list.add("elem 2");
		System.out.println("size: " + list.size()); // 2
		System.out.println(list); // [elem 1, elem 2]

		list.remove(0);
		System.out.println("size: " + list.size()); // 1
		System.out.println(list); // [elem 2]

		List<String> list2 = new ArrayList<String>();
		list2.add("item 1");
		list2.add("item 2");

		list.addAll(list2);
		System.out.println(list); // [elem 1, item 1, item 2]
	}

}
