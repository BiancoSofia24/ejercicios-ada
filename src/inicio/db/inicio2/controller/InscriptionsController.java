package inicio.db.inicio2.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.InscriptionsDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Inscription;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.utils.Util;

public class InscriptionsController {

	// Incomplete
	public static void inscriptionsOptions(int option, Scanner scan, Connection con) throws SQLException {
		while (option != 0) {
			switch (option) {
			case 1:
				newInscription(scan, con);
				break;
			case 2:
				viewInscriptions(con);
				break;
			case 3:
				updateInscription(scan, con);
				break;
			case 4:
				deleteInscription(scan, con);
				break;
			case 5:
				createFile(scan, con);
				break;
			}
			option = showInscriptionsSubmenu(scan);
		}
	}

	public static String inscriptionsFileContent(Inscription inscription, Connection con) throws SQLException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = simpleDate.format(new Date());
		String fileContent = "Fecha de creación: " + date + '\n' + "Inscripción #" + inscription.getIdInsc() + '\n'
				+ "------------------" + '\n' + '\n' + StudentsDAO.findById(inscription.getIdStudent(), con) + '\n'
				+ CoursesDAO.findById(inscription.getIdCourse(), con) + '\n' + "Comisión: "
				+ Util.valueForNullString(inscription.getCommission()) + '\n' + "Estado: " + inscription.getStatus()
				+ '\n' + '\n' + "Notas" + '\n' + "----------" + '\n' + '\n' + "Nota Parcial: "
				+ inscription.getPartialNote() + '\n' + "Nota Final: " + inscription.getFinalNote();
		return fileContent;
	}

	public static void createFileFromInscription(String absolutePath, Inscription inscription, Connection con)
			throws SQLException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
			String fileContent = inscriptionsFileContent(inscription, con);
			bufferedWriter.write(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createFile(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Crear archivo con registro");
		System.out.print("Ingrese id de la inscripción -> ");
		int idInsc = scan.nextInt();
		Inscription inscription = InscriptionsDAO.findById(idInsc, con);
		if (inscription == null) {
			Util.showError("Registro inexistente");
		} else {
			String directory = "src/inicio/db/inicio2/files/inscriptions";
			String fileName = "Inscripcion#" + idInsc + ".txt";
			String absolutePath = directory + fileName;
			createFileFromInscription(absolutePath, inscription, con);
			System.out.println("Archivo creado exitosamente");
		}
	}

	public static void deleteInscription(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Inscripción");
		System.out.print("Ingrese id de la inscripción -> ");
		int idInsc = scan.nextInt();
		Inscription actualInscription = InscriptionsDAO.findById(idInsc, con);
		if (actualInscription == null) {
			System.err.println("Registro inexistente");
		} else {
			showInscription(actualInscription, con);
			System.out.println();
			System.out.print("¿Está seguro de eliminar esta inscripción? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = InscriptionsDAO.delete(idInsc, con);
				if (deleted == 1) {
					System.out.println("Registro eliminado");
				} else {
					Util.showError("Registro inexistente");
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}

	}

	private static void showInscription(Inscription actualInscription, Connection con) throws SQLException {
		Util.showSubtitle("Inscripción #" + actualInscription.getIdInsc());
		System.out.println(StudentsDAO.findById(actualInscription.getIdStudent(), con));
		System.out.println(CoursesDAO.findById(actualInscription.getIdCourse(), con));
		System.out.println("Estado: " + actualInscription.getStatus());
	}

	// Incomplete
	public static void updateInscription(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Inscripción");
		System.out.print("Ingrese id de la inscripción -> ");
		int idInsc = scan.nextInt();
		Inscription actualInscription = InscriptionsDAO.findById(idInsc, con);
		if (actualInscription == null) {
			System.err.println("Registro inexistente");
		} else {
			showFullInscription(actualInscription, con);
		}
	}

	private static void showFullInscription(Inscription actualInscription, Connection con) throws SQLException {
		Util.showSubtitle("Inscripción #" + actualInscription.getIdInsc());
		System.out.println(StudentsDAO.findById(actualInscription.getIdStudent(), con));
		System.out.println(CoursesDAO.findById(actualInscription.getIdCourse(), con));
		System.out.println("Comisión: " + actualInscription.getCommission());
		System.out.println("Estado: " + actualInscription.getStatus());
		Util.showSubtitle("Notas");
		System.out.println("Nota Parcial: " + actualInscription.getPartialNote());
		System.out.println("Nota Final: " + actualInscription.getFinalNote());
	}

	public static void viewInscriptions(Connection con) throws SQLException {
		Util.showTitle("Lista de Inscripciones");
		List<Inscription> inscriptionsList = InscriptionsDAO.findAll(con);
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

	public static void newInscription(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nueva Inscripción");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();

		Student student = StudentsDAO.findById(idStudent, con);
		if (student == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(student);
			System.out.print("Ingrese id del curso -> ");
			int idCourse = scan.nextInt();
			Course course = CoursesDAO.findById(idCourse, con);
			if (course == null) {
				Util.showError("Registro inexistente");
			} else {
				System.out.println(course);
				System.out.println();
				System.out.print("¿Desea crear este registro? y/n -> ");
				String opt = scan.next();
				if (opt.toUpperCase().equals("Y")) {
					String status = "active";
					Inscription inscription = new Inscription(student, course, status);
					int inserted = InscriptionsDAO.insert(inscription, con);
					if (inserted == 1) {
						System.out.println("Registro creado exitosamente");
					} else {
						Util.showError("Error al crear el registro");
					}
				} else if (opt.toUpperCase().equals("N")) {
					System.out.println("Registro no creado");
				}
			}
		}
	}

	// Incomplete
	public static int showInscriptionsSubmenu(Scanner scan) {
		Util.showTitle("Menú Inscripciones");
		System.out.println("1 - Nueva Inscripción");
		System.out.println("2 - Ver Inscripciones");
		System.out.println("3 - Modificar Inscripción");
		System.out.println("4 - Eliminar Inscripción");
		System.out.println("5 - Crear archivo con registro");
		// Student per course. Search by teacher, status, commission, course
		System.out.println("Faltan opciones :)");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
