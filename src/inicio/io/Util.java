package inicio.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<String> readFile(String absolutePath) {
		List<String> lines = new ArrayList<String>();
		// Read the content from file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
