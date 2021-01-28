package inicio.logs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtil {

	public static void escribir(LogInscription log) {
		// Write the content in file
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/inicio/logs/logs.txt", true))) {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String momento = simpleFormat.format(new Date());
			bufferedWriter.write(momento + " " + log.toString());
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public static List<String> lecturaArchivo(String absolutePath) {

		List<String> lineas = new ArrayList<String>();
		// Read the content from file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				lineas.add(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return lineas;
	}

}
