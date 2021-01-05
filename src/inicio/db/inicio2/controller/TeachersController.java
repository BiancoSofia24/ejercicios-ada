package inicio.db.inicio2.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.TeachersDAO;
import inicio.db.inicio2.model.Teacher;
import inicio.db.inicio2.utils.Util;

public class TeachersController {

	public static void teachersOptions(int option, Scanner scan, Connection con) throws SQLException {
		while (option != 0) {
			switch (option) {
			case 1:
				newTeacher(scan, con);
				break;
			case 2:
				viewTeachers(con);
				break;
			case 3:
				updateTeacher(scan, con);
				break;
			case 4:
				deleteTeacher(scan, con);
				break;
			case 5:
				findTeacherByName(scan, con);
				break;
			case 6:
				findTeacherByLastName(scan, con);
				break;
			}
			option = showTeachersSubmenu(scan);
		}

	}

	public static void findTeacherByLastName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Profesor por Apellido");
		System.out.print("Ingrese apellido del profesor: ");
		String teacherLName = scan.next();
		List<Teacher> teachersListByLastName = TeachersDAO.findByLastName(teacherLName, con);
		Util.showSubtitle("Id | Apellido | Nombre  | Correo Electrónico   | Especialidad");
		teachersListByLastName.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName() + " | "
					+ Util.valueForStringNull(t.gettEmail()) + " | " + Util.valueForStringNull(t.getSpecialty()));
		});
	}

	public static void findTeacherByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Profesor por Nombre");
		System.out.print("Ingrese nombre del profesor: ");
		String teacherName = scan.next();
		List<Teacher> teachersListByName = TeachersDAO.findByName(teacherName, con);
		Util.showSubtitle("Id | Nombre | Apellido  | Correo Electrónico   | Especialidad");
		teachersListByName.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName() + " | "
					+ Util.valueForStringNull(t.gettEmail()) + " | " + Util.valueForStringNull(t.getSpecialty()));
		});
	}

	public static void deleteTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Profesor");
		System.out.print("Ingrese id del profesor a eliminar -> ");
		int idTeacher = scan.nextInt();
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualTeacher);
			System.out.println();
			System.out.print("¿Está seguro de eliminar este profesor? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = TeachersDAO.delete(idTeacher, con);
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

	public static void updateTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Profesor");
		System.out.print("Ingrese id del profesor registrado a modificar -> ");
		int idTeacher = scan.nextInt();
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualTeacher);
			System.out.println("Email: " + Util.valueForStringNull(actualTeacher.gettEmail()));
			System.out.println("Especialidad: " + Util.valueForStringNull(actualTeacher.getSpecialty()));
			System.out.println();
			System.out.print("¿Desea editar este profesor? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nombre del profesor -> ");
				String teacherName = scan.next();
				System.out.print("Ingrese apellido del profesor -> ");
				String teacherLName = scan.next();
				if (Util.validateStringLength(teacherName) && Util.validateStringLength(teacherLName)) {
					Util.showError("Error de ingreso. Texto inválido");
				} else {
					System.out.print("Ingrese correo electrónico del profesor -> ");
					String teacherEmail = scan.next();
					// Validate email
					System.out.print("Ingrese especialidad -> ");
					String teacherSpecialty = scan.next();
					Teacher teacher = new Teacher(teacherName, teacherLName, teacherEmail, teacherSpecialty);
					teacher.setIdTeacher(idTeacher);
					int updated = TeachersDAO.update(teacher, con);
					if (updated == 1) {
						System.out.println("Profesor editado correctamente");
					} else {
						Util.showError("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}

	}

	public static void newTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Profesor");
		System.out.print("Ingrese nombre del profesor -> ");
		String teacherName = scan.next();
		System.out.print("Ingrese apellido del profesor -> ");
		String teacherLName = scan.next();
		if (Util.validateStringLength(teacherName) && Util.validateStringLength(teacherLName)) {
			Util.showError("Error de ingreso. Texto inválido");
		} else {
			System.out.print("Ingrese correo electrónico del profesor -> ");
			String teacherEmail = scan.next();
			// Validate email
			System.out.print("Ingrese especialidad -> ");
			String teacherSpecialty = scan.next();
			Teacher teacher = new Teacher(teacherName, teacherLName, teacherEmail, teacherSpecialty);
			int inserted = TeachersDAO.insert(teacher, con);
			if (inserted == 1) {
				System.out.println("Registro creado exitosamente");
			} else {
				Util.showError("Error de ingreso");
			}
		}
	}

	public static void viewTeachers(Connection con) throws SQLException {
		Util.showTitle("Lista de Profesores");
		List<Teacher> teachersList = TeachersDAO.findAll(con);
		Util.showSubtitle("Id | Profesor     | Correo Electrónico   | Especialidad");
		teachersList.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName() + " | "
					+ Util.valueForStringNull(t.gettEmail()) + " | " + Util.valueForStringNull(t.getSpecialty()));
		});
	}

	public static int showTeachersSubmenu(Scanner scan) {
		Util.showTitle("Menú Profesores");
		System.out.println("1 - Nuevo Profesor");
		System.out.println("2 - Ver Profesores");
		System.out.println("3 - Modificar Profesor");
		System.out.println("4 - Eliminar Profesor");
		System.out.println("5 - Buscar Profesor por Nombre");
		System.out.println("6 - Buscar Profesor por Apellido");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
