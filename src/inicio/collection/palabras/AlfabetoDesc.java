package inicio.collection.palabras;

import java.util.Comparator;

public class AlfabetoDesc implements Comparator<String> {

	@Override
	public int compare(String word1, String word2) {
		return word2.compareTo(word1);
	}

}
