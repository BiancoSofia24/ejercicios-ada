package inicio.collection.inicial;

import java.util.Random;

public class AppRandom {

	public static void main(String[] args) {

		Random randomNumber = new Random();
		int number = randomNumber.nextInt(5); // Un número aleatorio entre 0 y 5, sin incluir el 5
		System.out.println("My random number: " + number);

		for (int i = 0; i < 10; i++) {
			number = randomNumber.nextInt(5);
			System.out.println(number);
		}

	}

}
