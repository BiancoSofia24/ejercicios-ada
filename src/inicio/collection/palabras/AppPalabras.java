package inicio.collection.palabras;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// //Buscar en internet un texto (parrafo)
//Investigar metod split en String (java api String en google)
//metodo split de String separa un string en un array de string dado un caracter
//Guardamos en una variable el texto seleccionado, lo separamos mediante el metod split
//en un array de palabras
//Generar un mapa que contenga la palabra y la cantidad de veces que se repitio esa palabra
//en el texto

//Opcional: obtener la palabra de mayor repeticion

public class AppPalabras {

	public static void main(String[] args) {

		String myText = "This is a cute text and is a text for fun and just for fun, because my cat, "
				+ "Franz, stole my dinner and i do not want to get mad.";
		myText = myText.toLowerCase();
		// \\s+|(?=[,.]) Regex for common paragraph
		String[] myStrArray = myText.split("\\s+|(?=[,.])");

		// Map<String, Integer> strMap = new TreeMap<String, Integer>();
		AlfabetoDesc alfabetoDesc = new AlfabetoDesc();
		Map<String, Integer> strMap = new TreeMap<String, Integer>(alfabetoDesc);
		String word;
		Integer value;
		Integer cont;
		for (int i = 0; i < myStrArray.length; i++) {
			System.out.println(myStrArray[i]);

			word = myStrArray[i];
			cont = strMap.get(word);
			value = cont == null ? 1 : ++cont;
			strMap.put(word, value);
		}

		System.out.println(strMap);

		// Loop through using lambda
		strMap.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});

		System.out.println("------------------------");

		// Loop through using while
		Set<String> keys = strMap.keySet();
		Iterator<String> iterator = keys.iterator();
		String key;
		Integer num;
		while (iterator.hasNext()) {
			key = iterator.next();
			num = strMap.get(key);
			System.out.println(key + ": " + num);
		}

	}

}
