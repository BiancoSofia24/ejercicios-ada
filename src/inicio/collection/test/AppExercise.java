package inicio.collection.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppExercise {

	public static void main(String[] args) {
		coffeList();

		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();

		lotteryNumbersSet();
	}

	private static void lotteryNumbersSet() {
		Set<Integer> numbers = new HashSet<Integer>();

		// Random random = new Random();
		// int randomNumber = random.nextInt(1000);

		numbers.add(1234);
		numbers.add(2345);
		numbers.add(3456);
		numbers.add(4567);
		numbers.add(5678);
		numbers.add(6789);
		numbers.add(4567);

		System.out.println("size: " + numbers.size());
		System.out.println(numbers);

		numbers.remove(1234);
		numbers.remove(3456);

		System.out.println("size: " + numbers.size());
		System.out.println(numbers);

	}

	private static void coffeList() {
		List<String> coffees = new ArrayList<String>();

		coffees.add("macchiato");
		coffees.add("espresso");
		coffees.add("latte");
		coffees.add("cappuchino");
		coffees.add("flat white");

		System.out.println("size: " + coffees.size());
		System.out.println(coffees);

		coffees.remove(2);
		System.out.println("size: " + coffees.size());
		System.out.println(coffees);

		coffees.remove("flat white");
		System.out.println("size: " + coffees.size());
		System.out.println(coffees);

		System.out.println();
		System.out.println("Using common for...");
		for (int i = 0; i < coffees.size(); i++) {
			String item = coffees.get(i);
			System.out.println(item);
		}

		System.out.println();
		System.out.println("For without index...");
		for (String item : coffees) {
			System.out.println(item);
		}

		System.out.println();
		System.out.println("Lambda (arrow function) with forEach...");
		coffees.forEach((item) -> {
			System.out.println(item);
		});
	}
}
