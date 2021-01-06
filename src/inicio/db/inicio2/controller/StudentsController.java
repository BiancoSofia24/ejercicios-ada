package inicio.db.inicio2.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.utils.Util;

public class StudentsController {

	public static void studentsOptions(int option, Scanner scan, Connection con) throws SQLException {
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
			}
			option = showStudentsSubmenu(scan);
		}
	}

	public static void findStudentByLastName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Alumno por Apellido");
		System.out.print("Ingrese apellido del alumno: ");
		String studentLName = scan.next();
		List<Student> studentsListByLastName = StudentsDAO.findByLastName(studentLName, con);
		Util.showSubtitle("Id | Apellido    | Nombre     | Correo Electrónico");
		studentsListByLastName.forEach((s) -> {
			System.out.println(s.getIdStudent() + " | " + s.getsLastName() + " | " + s.getsName() + " | "
					+ Util.valueForNullString(s.getsEmail()));
		});
	}

	public static void findStudentByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Alumno por Nombre");
		System.out.print("Ingrese nombre del alumno: ");
		String studentName = scan.next();
		List<Student> studentsListByName = StudentsDAO.findByName(studentName, con);
		Util.showSubtitle("Id | Nombre   | Apellido    | Correo Electrónico");
		studentsListByName.forEach((s) -> {
			System.out.println(s.getIdStudent() + " | " + s.getsName() + " | " + s.getsLastName() + " | "
					+ Util.valueForNullString(s.getsEmail()));
		});
	}

	public static void deleteStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Alumno");
		System.out.print("Ingrese id del alumno a eliminar -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println();
			System.out.print("¿Está seguro de eliminar este alumno? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = StudentsDAO.delete(idStudent, con);
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

	public static void updateStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Alumno");
		System.out.print("Ingrese id del alumno registrado a modificar -> ");
		int idStudent = scan.nextInt();
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
				System.out.print("Ingrese nombre del alumno -> ");
				String studentName = scan.next();
				System.out.print("Ingrese apellido del alumno -> ");
				String studentLName = scan.next();
				if (Util.validateStringLength(studentName) && Util.validateStringLength(studentLName)) {
					Util.showError("Error de ingreso. Texto inválido");
				} else {
					System.out.print("Ingrese correo electrónico del alumno -> ");
					String studentEmail = scan.next();
					// Validate email
					Student student = new Student(studentName, studentLName, studentEmail);
					student.setIdStudent(idStudent);
					int updated = StudentsDAO.update(student, con);
					if (updated == 1) {
						System.out.println("Registro editado exitosamente");
					} else {
						Util.showError("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	public static void newStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Alumno");
		System.out.print("Ingrese nombre del alumno -> ");
		String studentName = scan.next();
		System.out.print("Ingrese apellido del alumno -> ");
		String studentLName = scan.next();
		if (Util.validateStringLength(studentName) && Util.validateStringLength(studentLName)) {
			Util.showError("Error de ingreso. Texto inválido");
		} else {
			System.out.print("Ingrese correo electrónico del alumno -> ");
			String studentEmail = scan.next();
			// Validate email
			Student student = new Student(studentName, studentLName, studentEmail);
			int inserted = StudentsDAO.insert(student, con);
			if (inserted == 1) {
				System.out.println("Registro creado exitosamente");
			} else {
				Util.showError("Error de ingreso");
			}
		}
	}

	public static void viewStudents(Connection con) throws SQLException {
		Util.showTitle("Lista de Alumnos");
		List<Student> studentsList = StudentsDAO.findAll(con);
		Util.showSubtitle("Id | Alumno      | Correo Electrónico");
		studentsList.forEach((s) -> {
			System.out.println(s.getIdStudent() + " | " + s.getsName() + " " + s.getsLastName() + " | "
					+ Util.valueForNullString(s.getsEmail()));
		});
	}

	public static int showStudentsSubmenu(Scanner scan) {
		Util.showTitle("Menú Alumnos");
		System.out.println("1 - Nuevo Alumno");
		System.out.println("2 - Ver Alumnos");
		System.out.println("3 - Modificar Alumno");
		System.out.println("4 - Eliminar Alumno");
		System.out.println("5 - Buscar Alumno por Nombre");
		System.out.println("6 - Buscar Alumno por Apellido");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
