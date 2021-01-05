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
		Util.showSubtitle("Apellido | Nombre");
		teachersListByLastName.forEach((t) -> {
			System.out.println(t.gettLastName() + " | " + t.gettName());
		});
	}

	public static void findTeacherByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Profesor por Nombre");
		System.out.print("Ingrese nombre del profesor: ");
		String teacherName = scan.next();
		List<Teacher> teachersListByName = TeachersDAO.findByName(teacherName, con);
		Util.showSubtitle("Nombre | Apellido");
		teachersListByName.forEach((t) -> {
			System.out.println(t.gettName() + " | " + t.gettLastName());
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
			System.out.print("�Est� seguro de eliminar este profesor? y/n -> ");
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
			System.out.println();
			System.out.print("�Desea editar este profesor? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nombre del profesor -> ");
				String teacherName = scan.next();
				System.out.print("Ingrese apellido del profesor -> ");
				String teacherLName = scan.next();
				if (Util.validateStringLength(teacherName) && Util.validateStringLength(teacherLName)) {
					Util.showError("Error de ingreso. Texto inv�lido");
				} else {
					Teacher teacher = new Teacher(teacherName, teacherLName);
					teacher.setIdTeacher(idTeacher);
					int updated = TeachersDAO.update(teacher, con);
					if (updated == 1) {
						System.out.println("Profesor editado correctamente");
					} else {
						Util.showError("Error en la edici�n de registro");
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
		String teachersName = scan.next();
		System.out.print("Ingrese apellido del profesor -> ");
		String teachersLastName = scan.next();
		if (Util.validateStringLength(teachersName) && Util.validateStringLength(teachersLastName)) {
			Util.showError("Error de ingreso. Texto inv�lido");
		} else {
			Teacher teacher = new Teacher(teachersName, teachersLastName);
			int inserted = TeachersDAO.insert(teacher, con);
			if (inserted == 1) {
				System.out.println("Profesor ingresado exitosamente");
			} else {
				Util.showError("Error de ingreso");
			}
		}
	}

	public static void viewTeachers(Connection con) throws SQLException {
		Util.showTitle("Lista de Profesores");
		List<Teacher> teachersList = TeachersDAO.findAll(con);
		Util.showSubtitle("Id | Profesor");
		teachersList.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName());
		});
	}

	public static int showTeachersSubmenu(Scanner scan) {
		Util.showTitle("Men� Profesores");
		System.out.println("1 - Nuevo Profesor");
		System.out.println("2 - Ver Profesores");
		System.out.println("3 - Modificar Profesor");
		System.out.println("4 - Eliminar Profesor");
		System.out.println("5 - Buscar Profesor por Nombre");
		System.out.println("6 - Buscar Profesor por Apellido");
		System.out.println("0 - Ir Atr�s");
		System.out.print("Opci�n -> ");
		return scan.nextInt();
	}

}
