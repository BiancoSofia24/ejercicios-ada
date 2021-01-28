package inicio.db.inicio2.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.InscriptionsDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Inscription;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.utils.Util;

public class InscriptionsHelper {

	public static void insert(Inscription inscription, Connection con) throws SQLException {
		int inserted = InscriptionsDAO.insert(inscription, con);
		if (inserted == 1) {
			System.out.println("Registro creado exitosamente");
		} else {
			Util.showError("Error al crear el registro");
		}
	}

	public static void showList(List<Inscription> inscriptionsList, Connection con) {
		Util.showSubtitle("Id | Alumno    | Curso    | Profesor    | Estado");
		inscriptionsList.forEach((i) -> {
			Student student;
			Course course;
			try {
				student = StudentsDAO.findById(i.getIdStudent(), con);
				course = CoursesDAO.findById(i.getIdCourse(), con);
				System.out.println(i.getIdInsc() + " | " + student.getsName() + " " + student.getsLastName() + " | "
						+ course.getcName() + " | " + i.getStatus());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	public static void showInscription(Inscription actualInscription, Connection con) throws SQLException {
		Util.showSubtitle("Inscripci�n #" + actualInscription.getIdInsc());
		System.out.println(StudentsDAO.findById(actualInscription.getIdStudent(), con));
		System.out.println(CoursesDAO.findById(actualInscription.getIdCourse(), con));
		System.out.println("Estado: " + actualInscription.getStatus());
	}

	public static void showFullInscription(Inscription actualInscription, Connection con) throws SQLException {
		Util.showSubtitle("Inscripci�n #" + actualInscription.getIdInsc());
		System.out.println(StudentsDAO.findById(actualInscription.getIdStudent(), con));
		System.out.println(CoursesDAO.findById(actualInscription.getIdCourse(), con));
		System.out.println("Comisi�n: " + actualInscription.getCommission());
		System.out.println("Estado: " + actualInscription.getStatus());
		Util.showSubtitle("Notas");
		System.out.println("Nota Parcial: " + actualInscription.getPartialNote());
		System.out.println("Nota Final: " + actualInscription.getFinalNote());
	}

	public static void delete(int idInsc, Connection con) throws SQLException {
		int deleted = InscriptionsDAO.delete(idInsc, con);
		if (deleted == 1) {
			System.out.println("Registro eliminado exitosamente");
		} else {
			Util.showError("Error al eliminar el registro");
		}
	}

	public static void createFile(Inscription inscription, Connection con) throws IOException, SQLException {
		String directory = "src/inicio/db/inicio2/files/inscriptions";
		String fileName = "Inscripcion#" + inscription.getIdInsc() + ".txt";
		String absolutePath = directory + fileName;
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath));
		String fileContent = fileContent(inscription, con);
		bufferedWriter.write(fileContent);
		bufferedWriter.close();
		System.out.println("Archivo creado exitosamente");
	}

	private static String fileContent(Inscription inscription, Connection con) throws SQLException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = simpleDate.format(new Date());
		String fileContent = "Fecha de creaci�n: " + date + '\n' + "Inscripci�n #" + inscription.getIdInsc() + '\n'
				+ "------------------" + '\n' + '\n' + StudentsDAO.findById(inscription.getIdStudent(), con) + '\n'
				+ CoursesDAO.findById(inscription.getIdCourse(), con) + '\n' + "Comisi�n: "
				+ Util.valueForNullString(inscription.getCommission()) + '\n' + "Estado: " + inscription.getStatus()
				+ '\n' + '\n' + "Notas" + '\n' + "----------" + '\n' + '\n' + "Nota Parcial: "
				+ inscription.getPartialNote() + '\n' + "Nota Final: " + inscription.getFinalNote();
		return fileContent;
	}

}
