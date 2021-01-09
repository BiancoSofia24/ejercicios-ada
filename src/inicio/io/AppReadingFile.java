package inicio.io;

import java.util.List;

public class AppReadingFile {

	public static void main(String[] args) {
		String absolutePath = "src/inicio/io/options.txt";
		List<String> options = Util.readFile(absolutePath);
		options.forEach(System.out::println);
	}

}
