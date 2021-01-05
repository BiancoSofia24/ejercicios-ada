package inicio.db.inicio2.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.utils.Util;

public class CourseController {

	public static int showCoursesSubmenu(Scanner scan) {
		Util.showTitle("Men� Curso");
		System.out.println("1 - Nuevo Curso");
		System.out.println("2 - Ver Cursos");
		System.out.println("3 - Modificar Curso");
		System.out.println("4 - Eliminar Curso");
		System.out.println("5 - Buscar Curso por Nombre");
		System.out.println("0 - Ir Atr�s");
		System.out.print("Opci�n -> ");
		return scan.nextInt();
	}

	public static void coursesOptions(int opt, Scanner scan, Connection con) throws SQLException {
		while (opt != 0) {
			switch (opt) {
			case 1:
				newCourse(scan, con);
				break;
			case 2:
				viewCourses(con);
				break;
			case 3:
				updateCourse(scan, con);
				break;
			case 4:
				deleteCourse(scan, con);
				break;
			case 5:
				findCourseByName(scan, con);
				break;
			}
			opt = showCoursesSubmenu(scan);
		}
	}

	public static void findCourseByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Curso por Nombre");
		System.out.print("Ingrese nombre del curso: ");
		String courseName = scan.next();
		List<Course> coursesListByName = CoursesDAO.findByName(courseName, con);
		Util.showSubtitle("Id | Curso");
		coursesListByName.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

	private static void deleteCourse(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Eliminar Curso");
		System.out.print("Ingrese id del curso a eliminar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("�Esta seguro de eliminar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = CoursesDAO.delete(idCourse, con);
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

	public static void updateCourse(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Curso");
		System.out.print("Ingrese id del curso a modificar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("�Desea editar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nuevo nombre del curso -> ");
				String courseName = scan.next();
				if (Util.validateStringLength(courseName)) {
					Util.showError("Error de ingreso. Texto inv�lido");
				} else {
					Course course = new Course(courseName);
					course.setIdCourse(idCourse);
					int updated = CoursesDAO.update(course, con);
					if (updated == 1) {
						System.out.println("Registro editado exitosamente");
					} else {
						Util.showError("Error en la edici�n de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	public static void newCourse(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Curso");
		System.out.print("Ingrese nombre del curso -> ");
		String courseName = scan.next();
		if (Util.validateStringLength(courseName)) {
			Util.showError("Error de ingreso. Texto inv�lido");
		} else {
			Course course = new Course(courseName);
			int inserted = CoursesDAO.insert(course, con);
			if (inserted == 1) {
				System.out.println("Registro creado exitosamente");
			} else {
				Util.showError("Error de ingreso");
			}
		}
	}

	public static void viewCourses(Connection con) throws SQLException {
		Util.showTitle("Lista de Cursos");
		List<Course> coursesList = CoursesDAO.findAll(con);
		Util.showSubtitle("Id | Curso");
		coursesList.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

}
