package inicio.db.inicio2.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.InscriptionsDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.DAO.TeachersDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Inscription;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.model.Teacher;
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
			}
			option = showInscriptionsSubmenu(scan);
		}
	}

	// Incomplete
	public static void deleteInscription(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Inscripción");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
		}
	}

	// Incomplete
	public static void updateInscription(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Alumno en Curso");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
		}
	}

	public static void viewInscriptions(Connection con) throws SQLException {
		Util.showTitle("Lista de Inscripciones");
		List<Inscription> inscriptionsList = InscriptionsDAO.findAll(con);
		Util.showSubtitle("Id | Alumno    | Curso    | Profesor    | Estado");
		inscriptionsList.forEach((i) -> {
			Student student;
			Course course;
			Teacher teacher;
			try {
				student = StudentsDAO.findById(i.getIdStudent(), con);
				course = CoursesDAO.findById(i.getIdCourse(), con);
				teacher = TeachersDAO.findById(i.getIdTeacher(), con);
				System.out.println(i.getIdInsc() + " | " + student.getsName() + " " + student.getsLastName() + " | "
						+ course.getcName() + " | " + teacher.gettName() + " " + teacher.gettLastName() + " | "
						+ i.getStatus());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	// Error for insert in InscriptionsDAO or in db
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
		// Student per course. Search by teacher, status, commission, course
		System.out.println("Faltan opciones :)");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
