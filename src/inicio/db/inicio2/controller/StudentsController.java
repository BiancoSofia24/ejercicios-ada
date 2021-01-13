package inicio.db.inicio2.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.helper.StudentsHelper;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.utils.Util;

public class StudentsController {

	public static void studentsOptions(int option, Scanner scan, Connection con) throws SQLException, IOException {
		while (option != 0) {
			switch (option) {
			case 1:
				newStudent(scan, con);
				break;
			case 2:
				viewStudents(con);
				break;
			case 3:
				updateStudent(scan, con);
				break;
			case 4:
				deleteStudent(scan, con);
				break;
			case 5:
				findStudentByName(scan, con);
				break;
			case 6:
				findStudentByLastName(scan, con);
				break;
			case 7:
				createFile(scan, con);
				break;
			}
			option = showStudentsSubmenu(scan);
		}
	}

	private static void createFile(Scanner scan, Connection con) throws SQLException, IOException {
		Util.showTitle("Crear archivo con registro");
		System.out.println("Se creara un archivo con los datos del alumno registrado.");
		System.out.print("¿Desea continuar? y/n -> ");
		String opt = scan.next();
		if (opt.toUpperCase().equals("Y")) {
			System.out.print("Ingrese id del alumno -> ");
			int idStudent = scan.nextInt();
			Student student = StudentsDAO.findById(idStudent, con);
			if (student == null) {
				Util.showError("Registro inexistente");
			} else {
				StudentsHelper.createFile(student, con);
			}
		} else if (opt.toUpperCase().equals("N")) {
			System.out.println("Archivo no creado");
		}
	}

	public static void findStudentByLastName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Alumno por Apellido");
		String studentLName = Util.requestStringFromUser(scan, "apellido", "alumno");
		List<Student> studentsListByLastName = StudentsDAO.findByLastName(studentLName, con);
		StudentsHelper.showListByLastName(studentsListByLastName);
	}

	public static void findStudentByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Alumno por Nombre");
		String studentName = Util.requestStringFromUser(scan, "nombre", "alumno");
		List<Student> studentsListByName = StudentsDAO.findByName(studentName, con);
		StudentsHelper.showList(studentsListByName);
	}

	public static void deleteStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Alumno");
		int idStudent = Util.requestIdFromUser(scan, "alumno registrado", "eliminar");
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println();
			System.out.print("¿Está seguro de eliminar este alumno? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				StudentsHelper.delete(idStudent, con);
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}
	}

	public static void updateStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Alumno");
		int idStudent = Util.requestIdFromUser(scan, "alumno registrado", "modificar");
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println("Email: " + Util.valueForNullString(actualStudent.getsEmail()));
			System.out.println();
			System.out.print("¿Desea editar este alumno? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				String studentName = Util.requestStringFromUser(scan, "nombre", "alumno");
				String studentLName = Util.requestStringFromUser(scan, "apellido", "alumno");
				while (Util.isValidStringLength(studentName) || Util.isValidStringLength(studentLName)) {
					Util.showError("Error de ingreso. Texto inválido");
					studentName = Util.requestStringFromUser(scan, "nombre", "curso");
					studentLName = Util.requestStringFromUser(scan, "apellido", "alumno");
				}
				if (!Util.isValidStringLength(studentName) && !Util.isValidStringLength(studentLName)) {
					String studentEmail = Util.requestStringFromUser(scan, "correo electrónico", "alumno");
					// Validate email
					Student student = new Student(idStudent, studentName, studentLName, studentEmail);
					StudentsHelper.update(student, con);
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	public static void newStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Alumno");
		String studentName = Util.requestStringFromUser(scan, "nombre", "alumno");
		String studentLName = Util.requestStringFromUser(scan, "apellido", "alumno");
		if (Util.isValidStringLength(studentName) && Util.isValidStringLength(studentLName)) {
			Util.showError("Error de ingreso. Texto inválido");
		} else {
			String studentEmail = Util.requestStringFromUser(scan, "correo electrónico", "alumno");
			// Validate email
			Student student = new Student(studentName, studentLName, studentEmail);
			StudentsHelper.insert(student, con);
		}
	}

	public static void viewStudents(Connection con) throws SQLException {
		Util.showTitle("Lista de Alumnos");
		List<Student> studentsList = StudentsDAO.findAll(con);
		StudentsHelper.showList(studentsList);
	}

	public static int showStudentsSubmenu(Scanner scan) {
		Util.showTitle("Menú Alumnos");
		System.out.println("1 - Nuevo Alumno");
		System.out.println("2 - Ver Alumnos");
		System.out.println("3 - Modificar Alumno");
		System.out.println("4 - Eliminar Alumno");
		System.out.println("5 - Buscar Alumno por Nombre");
		System.out.println("6 - Buscar Alumno por Apellido");
		System.out.println("7 - Imprimir registro de Alumnos");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
