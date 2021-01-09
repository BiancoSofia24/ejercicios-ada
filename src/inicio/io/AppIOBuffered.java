package inicio.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppIOBuffered {

	public static void main(String[] args) {
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// Write the content in file
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
			String fileContent = "This is a sample text." + '\n' + "Second line.";
			bufferedWriter.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read the content from file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
