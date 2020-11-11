package inicio.collection.inicial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import inicio.mediosdepago.entidades.Tarjeta;

public class AppCollection {

	public static void main(String[] args) {

		// List from another Object created by me
		List<Tarjeta> cards = new ArrayList<Tarjeta>();
		Tarjeta tdc1 = new Tarjeta(500, "ARS", "4141", "12/2021");
		Tarjeta tdc2 = new Tarjeta(250, "ARS", "4949", "12/2021");
		cards.add(tdc1);
		cards.add(tdc2);

		// System.out.println("Cards list...");
		// System.out.println(cards);

		System.out.println();

		// listsTest();

		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();

		// setTest();

		mapTest();

		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("ArrayList...");

		// ArrayList => Each element is next to the other
		List<String> myArrayList = new ArrayList<String>();
		// LinkedList => More memory space, each element it's linked to the next
		List<String> myLinkedList = new LinkedList<String>();

		myArrayList.add("b");
		myArrayList.add("a");
		myArrayList.add("d");
		myArrayList.add("c");
		// System.out.println(myArrayList); // [b, a, d, c]

		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("LinkedList...");

		myLinkedList.add("b");
		myLinkedList.add("a");
		myLinkedList.add("d");
		myLinkedList.add("c");
		// System.out.println(myLinkedList); // [b, a, d, c]

	}

	private static void mapTest() {
		// Values inside Map<Objetc, Object> can be any type of Object (String,
		// Integer...)
		// Map<Key, Value>
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("Argentina", "Buenos Aires");
		capitals.put("Perú", "Lima");
		capitals.put("Venezuela", "Caracas");

		System.out.println(capitals.get("Venezuela"));
		System.out.println(capitals.get("Colombia"));

		// Loop through the map
		Set<String> keys = capitals.keySet(); // Set of keys from the map
		Iterator<String> iterator = keys.iterator();
		String key;
		String value;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = capitals.get(key);
			System.out.println(key + ": " + value);
		}

		System.out.println();

		// Map with integer key and Tarjeta as value
		Map<Integer, Tarjeta> cardsMap = new HashMap<Integer, Tarjeta>();
		Tarjeta card1 = new Tarjeta(200, "ARS", "4141", "01/21");
		Tarjeta card2 = new Tarjeta(300, "ARS", "4545", "02/21");
		Tarjeta card3 = new Tarjeta(100, "ARS", "4949", "03/21");
		cardsMap.put(1001, card1);
		cardsMap.put(1002, card2);
		cardsMap.put(1003, card3);

		System.out.println(cardsMap.get(1005));
		System.out.println(cardsMap.get(1002));

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
		// In a Set there are no repeating elements
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
