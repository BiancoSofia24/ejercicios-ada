package inicio.collection.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppCarts {

	public static void main(String[] args) {

		List<Integer> cards = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			cards.add(i);
		}

		System.out.println(cards);

		Random random = new Random();

		// At least 1 card left in my list
		while (cards.size() > 1) {

			int number = random.nextInt(cards.size()); // Random between the quantity of cards

			System.out.println("Tu carta: " + cards.get(number));
			cards.remove(number);

			// Set<Integer> usedCards = new HashSet<Integer>();

			// while (usedCards.size() < 5) {
			// if (!usedCards.contains(number)) {
			// usedCards.add(number);
			// }
			// }

		}

		// chooseCard(cards);

		System.out.println(cards);

	}

	private static void chooseCard(List<Integer> cards) {

	}

}
