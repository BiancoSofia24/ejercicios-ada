package inicio.db.inicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.AdminDB;
import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Student;

public class AppJDBC {

	private static final int MAX_CHAR = 50;
	private static final int MIN_CHAR = 1;

	public static void main(String[] args) {
		showTitle("Mis Cursos");
		try {
			Connection con = AdminDB.getConnection();
			Scanner scan = new Scanner(System.in);
			int opt = optionsMenu(scan);
			int crudOpt;
			while (opt != 0) {
				switch (opt) {
				case 1:
					crudOpt = showSubmenu(scan, "Alumno");
					studentsOptions(crudOpt, scan, con);
					break;
				case 2:
					crudOpt = showSubmenu(scan, "Curso");
					coursesOptions(crudOpt, scan, con);
					break;
				}
				opt = optionsMenu(scan);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void studentsOptions(int opt, Scanner scan, Connection con) throws SQLException {
		while (opt != 0) {
			switch (opt) {
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
			}
			opt = showSubmenu(scan, "Alumno");
		}
	}

	private static void deleteStudent(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Alumno");
		System.out.print("Ingrese id del alumno a eliminar -> ");
		int idStud = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStud, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println();
			System.out.print("¿Está seguro de eliminar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = StudentsDAO.delete(idStud, con);
				if (deleted == 1) {
					System.out.println("Registro eliminado");
				} else {
					System.err.println("Registro inexistente");
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}
	}

	private static void updateStudent(Scanner scan, Connection con) throws SQLException {
		showTitle("Modificar Alumno");
		System.out.print("Ingrese id del alumno registrado a modificar -> ");
		int idStud = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStud, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println();
			System.out.print("¿Desea editar este alumno? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nombre del alumno -> ");
				String studentName = scan.next();
				System.out.print("Ingrese apellido del alumno -> ");
				String studentLName = scan.next();
				if (validateString(studentName) && validateString(studentLName)) {
					System.out.println("Error de ingreso. Texto inválido");
				} else {
					Student student = new Student(studentName, studentLName);
					student.setIdStud(idStud);
					int updated = StudentsDAO.update(student, con);
					if (updated == 1) {
						System.out.println("Alumno editado correctamente");
					} else {
						System.err.println("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	private static void newStudent(Scanner scan, Connection con) throws SQLException {
		showTitle("Nuevo Alumno");
		System.out.print("Ingrese nombre del alumno -> ");
		String studentName = scan.next();
		System.out.print("Ingrese apellido del alumno -> ");
		String studentLName = scan.next();
		if (validateString(studentName) && validateString(studentLName)) {
			System.out.println("Error de ingreso. Texto inválido");
		} else {
			Student student = new Student(studentName, studentLName);
			int inserted = StudentsDAO.insert(student, con);
			if (inserted == 1) {
				System.out.println("Alumno ingresado exitosamente");
			} else {
				System.err.println("Error de ingreso");
			}
		}

	}

	private static void viewStudents(Connection con) throws SQLException {
		showTitle("Lista de Alumnos");
		List<Student> studentsList = StudentsDAO.findAll(con);
		studentsList.forEach((s) -> {
			System.out.println(s.getIdStud() + " | " + s.getsName() + " " + s.getsLastName());
		});
	}

	private static void coursesOptions(int opt, Scanner scan, Connection con) throws SQLException {
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
			}
			opt = showSubmenu(scan, "Curso");
		}
	}

	private static void deleteCourse(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Curso");
		System.out.print("Ingrese id del curso a eliminar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("¿Esta seguro de eliminar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				int deleted = CoursesDAO.delete(idCourse, con);
				if (deleted == 1) {
					System.out.println("Registro eliminado");
				} else {
					System.err.println("Registro inexistente");
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}
	}

	private static void updateCourse(Scanner scan, Connection con) throws SQLException {
		showTitle("Modificar Curso");
		System.out.print("Ingrese id del curso a modificar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("¿Desea editar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nuevo nombre del curso -> ");
				String courseName = scan.next();
				if (validateString(courseName)) {
					System.err.println("Error de ingreso. Texto inválido");
				} else {
					Course course = new Course(courseName);
					course.setIdCourse(idCourse);
					int updated = CoursesDAO.update(course, con);
					if (updated == 1) {
						System.out.println("Curso editado correctamente");
					} else {
						System.err.println("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	private static void newCourse(Scanner scan, Connection con) throws SQLException {
		showTitle("Nuevo Curso");
		System.out.print("Ingrese nombre del curso -> ");
		String courseName = scan.next();
		if (validateString(courseName)) {
			System.out.println("Error de ingreso. Texto inválido");
		} else {
			Course course = new Course(courseName);
			int inserted = CoursesDAO.insert(course, con);
			if (inserted == 1) {
				System.out.println("Curso ingresado exitosamente");
			} else {
				System.err.println("Error de ingreso");
			}
		}
	}

	private static boolean validateString(String text) {
		boolean notValid = text.length() < MIN_CHAR || text.length() > MAX_CHAR;
		return notValid;

	}

	private static void viewCourses(Connection con) throws SQLException {
		showTitle("Lista de Cursos");
		List<Course> coursesList = CoursesDAO.findAll(con);
		coursesList.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

	private static int showSubmenu(Scanner scan, String text) {
		showTitle("Menú " + text + "s");
		System.out.println("1 - Nuevo " + text);
		System.out.println("2 - Ver " + text + "s");
		System.out.println("3 - Modificar " + text);
		System.out.println("4 - Eliminar " + text);
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static int optionsMenu(Scanner scan) {
		showTitle("Menú Principal");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos");
		System.out.println("0 - Salir");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	public static void showTitle(String text) {
		System.out.println();
		System.out.println("----------------------");
		System.out.println(text);
		System.out.println("----------------------");
	}
}
