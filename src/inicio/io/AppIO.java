package inicio.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppIO {

	public static void main(String[] args) {
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// Write the content in file
		try (FileWriter fileWriter = new FileWriter(absolutePath)) {
			String fileContent = "This is a sample text.";
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (IOException e) {
			// Handling exception
		}

		// Read the content from file
		try (FileReader fileReader = new FileReader(absolutePath)) {
			int ch = fileReader.read();
			while (ch != -1) {
				System.out.print((char) ch);
				ch = fileReader.read();
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// Handling exception
		} catch (IOException e) {
			// Handling exception
		}
	}

}
