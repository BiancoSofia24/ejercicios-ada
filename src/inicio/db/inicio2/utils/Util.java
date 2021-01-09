package inicio.db.inicio2.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.model.Inscription;

public class Util {

	private static final int MAX_CHAR = 50;
	private static final int MIN_CHAR = 1;

	public static void createFile(String absolutePath, Inscription inscription, Connection con) throws SQLException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
			String fileContent = inscriptionsFileContent(inscription, con);
			bufferedWriter.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String inscriptionsFileContent(Inscription inscription, Connection con) throws SQLException {
		String fileContent = "Inscripción #" + inscription.getIdInsc() + '\n' + "-------------------------" + '\n'
				+ StudentsDAO.findById(inscription.getIdStudent(), con) + '\n'
				+ CoursesDAO.findById(inscription.getIdCourse(), con) + '\n' + "Comisión: "
				+ inscription.getCommission() + '\n' + "Estado: " + inscription.getStatus() + '\n' + "Notas" + '\n'
				+ "-----------------" + '\n' + "Nota Parcial: " + inscription.getPartialNote() + '\n' + "Nota Final: "
				+ inscription.getFinalNote();
		return fileContent;
	}

	public static String valueForNullString(String text) {
		if (text == null) {
			return "none";
		}
		return text;
	}

	public static boolean isValidStringLength(String text) {
		boolean notValid = text.length() < MIN_CHAR || text.length() > MAX_CHAR;
		return notValid;
	}

	public static void showError(String text) {
		System.out.println(" *** " + text + " *** ");
	}

	public static void showSubtitle(String text) {
		System.out.println();
		System.out.println(text);
		System.out.println("-------------------------------------");
	}

	public static void showTitle(String text) {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println(text);
		System.out.println("-------------------------------------");
	}
}
