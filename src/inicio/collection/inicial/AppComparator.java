package inicio.collection.inicial;

import java.util.Set;
import java.util.TreeSet;

import inicio.mediosdepago.entidades.Tarjeta;

public class AppComparator {

	public static void main(String[] args) {

		// Es necesario crear una instancia de mi comparador debido a que
		// compare(Object o1, Object o2) es un método de una interfaz de java
		MiComparator miComp = new MiComparator();
		Set<String> set = new TreeSet<String>(miComp);
		set.add("string2");
		set.add("string1");

		System.out.println(set);

		CardComparator cardComp = new CardComparator();
		Set<Tarjeta> cards1 = new TreeSet<Tarjeta>(cardComp);

		Tarjeta card1 = new Tarjeta(200, "ARS", "4141", "10/12/2021");
		Tarjeta card2 = new Tarjeta(500, "ARS", "4949", "15/08/2022");

		cards1.add(card1);
		cards1.add(card2);

	}

}
