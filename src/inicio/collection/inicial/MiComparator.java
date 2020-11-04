package inicio.collection.inicial;

import java.util.Comparator;

// Comparator es una interfaz de java 
public class MiComparator implements Comparator<String> {

	// compare(Object o1, Object o2) es el método comparar de la interfaz Comparator
	@Override
	public int compare(String o1, String o2) {
		// o1 > o2 => 1
		// o1 = o1 => 0
		// o1 < o2 => -1
		return o1.compareTo(o2);
	}

}
