package inicio.db.inicio2.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.TeachersDAO;
import inicio.db.inicio2.helper.TeachersHelper;
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
		TeachersHelper.showListByLastName(teachersListByLastName);
	}

	public static void findTeacherByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Profesor por Nombre");
		System.out.print("Ingrese nombre del profesor: ");
		String teacherName = scan.next();
		List<Teacher> teachersListByName = TeachersDAO.findByName(teacherName, con);
		TeachersHelper.showList(teachersListByName);
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
				TeachersHelper.delete(idTeacher, con);
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}

	}

	public static void updateTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Profesor");
		int idTeacher = Util.requestIdFromUser(scan, "profesor registrado", "modificar");
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualTeacher);
			System.out.println("Email: " + Util.valueForNullString(actualTeacher.gettEmail()));
			System.out.println("Especialidad: " + Util.valueForNullString(actualTeacher.getSpecialty()));
			System.out.println();
			System.out.print("�Desea editar este profesor? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				String teacherName = Util.requestStringFromUser(scan, "nombre", "profesor");
				String teacherLName = Util.requestStringFromUser(scan, "apellido", "profesor");
				while (Util.isValidStringLength(teacherName) || Util.isValidStringLength(teacherLName)) {
					Util.showError("Error de ingreso. Texto inv�lido");
					teacherName = Util.requestStringFromUser(scan, "nombre", "profesor");
					teacherLName = Util.requestStringFromUser(scan, "apellido", "profesor");
				}
				if (!Util.isValidStringLength(teacherName) && !Util.isValidStringLength(teacherLName)) {
					String teacherEmail = Util.requestStringFromUser(scan, "correo electr�nico", "profesor");
					// Validate email
					System.out.print("Ingrese especialidad -> ");
					String teacherSpecialty = scan.next();
					Teacher teacher = new Teacher(idTeacher, teacherName, teacherLName, teacherEmail, teacherSpecialty);
					TeachersHelper.update(teacher, con);
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}

	}

	public static void newTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Profesor");
		String teacherName = Util.requestStringFromUser(scan, "nombre", "profesor");
		String teacherLName = Util.requestStringFromUser(scan, "apellido", "profesor");
		if (Util.isValidStringLength(teacherName) && Util.isValidStringLength(teacherLName)) {
			Util.showError("Error de ingreso. Texto inv�lido");
		} else {
			String teacherEmail = Util.requestStringFromUser(scan, "correo electr�nico", "profesor");
			// Validate email
			System.out.print("Ingrese especialidad -> ");
			String teacherSpecialty = scan.next();
			Teacher teacher = new Teacher(teacherName, teacherLName, teacherEmail, teacherSpecialty);
			TeachersHelper.insert(teacher, con);
		}
	}

	public static void viewTeachers(Connection con) throws SQLException {
		Util.showTitle("Lista de Profesores");
		List<Teacher> teachersList = TeachersDAO.findAll(con);
		TeachersHelper.showList(teachersList);
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
