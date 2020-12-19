package inicio.db.inicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import inicio.db.inicio2.DAO.AdminDB;
import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.DAO.InscriptionsDAO;
import inicio.db.inicio2.DAO.StudentsDAO;
import inicio.db.inicio2.DAO.TeachersDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Inscription;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.model.Teacher;

public class AppJDBC {

	private static final int MAX_CHAR = 50;
	private static final int MIN_CHAR = 1;

	public static void main(String[] args) {
		showTitle("Mis Cursos");
		try {
			Connection con = AdminDB.getConnection();
			Scanner scan = new Scanner(System.in);
			int option = showMenu(scan);
			int crudOption;
			while (option != 0) {
				switch (option) {
				case 1:
					crudOption = showStudentsSubmenu(scan);
					showStudentsOptions(crudOption, scan, con);
					break;
				case 2:
					crudOption = showCoursesSubmenu(scan);
					showCoursesOptions(crudOption, scan, con);
					break;
				case 3:
					crudOption = showTeachersSubmenu(scan);
					showTeachersOptions(crudOption, scan, con);
					break;
				case 4:
					crudOption = showInscriptionsSubmenu(scan);
					showInscriptionsOptions(crudOption, scan, con);
					break;
				}
				option = showMenu(scan);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void showInscriptionsOptions(int option, Scanner scan, Connection con) throws SQLException {
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

	// Incompleta
	private static void deleteInscription(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Inscripción");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
		}

	}

	// Incompleta
	private static void updateInscription(Scanner scan, Connection con) throws SQLException {
		showTitle("Modificar Alumno en Curso");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			System.err.println("Registro inexistente");
		} else {
			System.out.println(actualStudent);
		}
	}

	private static void viewInscriptions(Connection con) throws SQLException {
		showTitle("Lista de Inscripciones");
		List<Inscription> inscriptionsList = InscriptionsDAO.findAll(con);
		showSubtitle("Id | Alumno       | Curso    | Profesor");
		inscriptionsList.forEach((i) -> {
			System.out.println(i.getIdInsc() + " | " + i.getStudent().getsName() + " " + i.getStudent().getsLastName()
					+ " | " + i.getCourse().getcName() + " | " + i.getTeacher().gettName() + " "
					+ i.getTeacher().gettLastName());
		});

	}

	// Incompleta
	private static void newInscription(Scanner scan, Connection con) throws SQLException {
		showTitle("Nueva Inscripción");
		System.out.print("Ingrese id del alumno -> ");
		int idStudent = scan.nextInt();
		System.out.print("Ingrese id del curso -> ");
		int idCourse = scan.nextInt();

		Student student = StudentsDAO.findById(idStudent, con);
		Course course = CoursesDAO.findById(idCourse, con);

		System.out.println(student + " en " + course);
	}

	private static int showInscriptionsSubmenu(Scanner scan) {
		showTitle("Menú Inscripciones");
		System.out.println("1 - Nueva Inscripción");
		System.out.println("2 - Ver Inscripciones");
		System.out.println("3 - Modificar Inscripción");
		System.out.println("4 - Eliminar Inscripción");
		System.out.println("5 - Buscar Alumnos por Curso"); // Alumno por curso
		System.out.println("6 - Buscar Alumno Inscrito"); // Curso por alumno
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static void showTeachersOptions(int option, Scanner scan, Connection con) throws SQLException {
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

	private static void findTeacherByLastName(Scanner scan, Connection con) throws SQLException {
		showTitle("Buscar Profesor por Apellido");
		System.out.print("Ingrese apellido del profesor: ");
		String teacherLName = scan.next();
		List<Teacher> teachersListByLastName = TeachersDAO.findByLastName(teacherLName, con);
		showSubtitle("Apellido | Nombre");
		teachersListByLastName.forEach((t) -> {
			System.out.println(t.gettLastName() + " | " + t.gettName());
		});
	}

	private static void findTeacherByName(Scanner scan, Connection con) throws SQLException {
		showTitle("Buscar Profesor por Nombre");
		System.out.print("Ingrese nombre del profesor: ");
		String teacherName = scan.next();
		List<Teacher> teachersListByName = TeachersDAO.findByName(teacherName, con);
		showSubtitle("Nombre | Apellido");
		teachersListByName.forEach((t) -> {
			System.out.println(t.gettName() + " | " + t.gettLastName());
		});
	}

	private static void deleteTeacher(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Profesor");
		System.out.print("Ingrese id del profesor a eliminar -> ");
		int idTeacher = scan.nextInt();
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			showError("Registro inexistente");
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
					showError("Registro inexistente");
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}

	}

	private static void updateTeacher(Scanner scan, Connection con) throws SQLException {
		showTitle("Modificar Profesor");
		System.out.print("Ingrese id del profesor registrado a modificar -> ");
		int idTeacher = scan.nextInt();
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			showError("Registro inexistente");
		} else {
			System.out.println(actualTeacher);
			System.out.println();
			System.out.print("¿Desea editar este profesor? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nombre del profesor -> ");
				String teacherName = scan.next();
				System.out.print("Ingrese apellido del profesor -> ");
				String teacherLName = scan.next();
				if (validateStringLength(teacherName) && validateStringLength(teacherLName)) {
					showError("Error de ingreso. Texto inválido");
				} else {
					Teacher teacher = new Teacher(teacherName, teacherLName);
					teacher.setIdTeacher(idTeacher);
					int updated = TeachersDAO.update(teacher, con);
					if (updated == 1) {
						System.out.println("Profesor editado correctamente");
					} else {
						showError("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}

	}

	private static void newTeacher(Scanner scan, Connection con) throws SQLException {
		showTitle("Nuevo Profesor");
		System.out.print("Ingrese nombre del profesor -> ");
		String teachersName = scan.next();
		System.out.print("Ingrese apellido del profesor -> ");
		String teachersLastName = scan.next();
		if (validateStringLength(teachersName) && validateStringLength(teachersLastName)) {
			showError("Error de ingreso. Texto inválido");
		} else {
			Teacher teacher = new Teacher(teachersName, teachersLastName);
			int inserted = TeachersDAO.insert(teacher, con);
			if (inserted == 1) {
				System.out.println("Profesor ingresado exitosamente");
			} else {
				showError("Error de ingreso");
			}
		}
	}

	private static void viewTeachers(Connection con) throws SQLException {
		showTitle("Lista de Profesores");
		List<Teacher> teachersList = TeachersDAO.findAll(con);
		showSubtitle("Id | Profesor");
		teachersList.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName());
		});
	}

	private static int showTeachersSubmenu(Scanner scan) {
		showTitle("Menú Profesores");
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

	private static void showStudentsOptions(int option, Scanner scan, Connection con) throws SQLException {
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

	private static void findStudentByLastName(Scanner scan, Connection con) throws SQLException {
		showTitle("Buscar Alumno por Apellido");
		System.out.print("Ingrese apellido del alumno: ");
		String studentLName = scan.next();
		List<Student> studentsListByLastName = StudentsDAO.findByLastName(studentLName, con);
		showSubtitle("Apellido | Nombre");
		studentsListByLastName.forEach((s) -> {
			System.out.println(s.getsLastName() + " | " + s.getsName());
		});
	}

	private static void findStudentByName(Scanner scan, Connection con) throws SQLException {
		showTitle("Buscar Alumno por Nombre");
		System.out.print("Ingrese nombre del alumno: ");
		String studentName = scan.next();
		List<Student> studentsListByName = StudentsDAO.findByName(studentName, con);
		showSubtitle("Nombre | Apellido");
		studentsListByName.forEach((s) -> {
			System.out.println(s.getsName() + " | " + s.getsLastName());
		});
	}

	private static void deleteStudent(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Alumno");
		System.out.print("Ingrese id del alumno a eliminar -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			showError("Registro inexistente");
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
					showError("Registro inexistente");
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no eliminado");
			}
		}
	}

	private static void updateStudent(Scanner scan, Connection con) throws SQLException {
		showTitle("Modificar Alumno");
		System.out.print("Ingrese id del alumno registrado a modificar -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			showError("Registro inexistente");
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
				if (validateStringLength(studentName) && validateStringLength(studentLName)) {
					showError("Error de ingreso. Texto inválido");
				} else {
					Student student = new Student(studentName, studentLName);
					student.setIdStudent(idStudent);
					int updated = StudentsDAO.update(student, con);
					if (updated == 1) {
						System.out.println("Alumno editado correctamente");
					} else {
						showError("Error en la edición de registro");
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
		if (validateStringLength(studentName) && validateStringLength(studentLName)) {
			showError("Error de ingreso. Texto inválido");
		} else {
			Student student = new Student(studentName, studentLName);
			int inserted = StudentsDAO.insert(student, con);
			if (inserted == 1) {
				System.out.println("Alumno ingresado exitosamente");
			} else {
				showError("Error de ingreso");
			}
		}
	}

	private static void viewStudents(Connection con) throws SQLException {
		showTitle("Lista de Alumnos");
		List<Student> studentsList = StudentsDAO.findAll(con);
		showSubtitle("Id | Alumno");
		studentsList.forEach((s) -> {
			System.out.println(s.getIdStudent() + " | " + s.getsName() + " " + s.getsLastName());
		});
	}

	private static int showStudentsSubmenu(Scanner scan) {
		showTitle("Menú Alumnos");
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

	private static void showCoursesOptions(int opt, Scanner scan, Connection con) throws SQLException {
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

	private static void findCourseByName(Scanner scan, Connection con) throws SQLException {
		showTitle("Buscar Curso por Nombre");
		System.out.print("Ingrese nombre del curso: ");
		String courseName = scan.next();
		List<Course> coursesListByName = CoursesDAO.findByName(courseName, con);
		showSubtitle("Id | Curso");
		coursesListByName.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

	private static void deleteCourse(Scanner scan, Connection con) throws SQLException {
		showTitle("Eliminar Curso");
		System.out.print("Ingrese id del curso a eliminar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			showError("Registro inexistente");
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
					showError("Registro inexistente");
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
			showError("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("¿Desea editar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nuevo nombre del curso -> ");
				String courseName = scan.next();
				if (validateStringLength(courseName)) {
					showError("Error de ingreso. Texto inválido");
				} else {
					Course course = new Course(courseName);
					course.setIdCourse(idCourse);
					int updated = CoursesDAO.update(course, con);
					if (updated == 1) {
						System.out.println("Curso editado correctamente");
					} else {
						showError("Error en la edición de registro");
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
		if (validateStringLength(courseName)) {
			showError("Error de ingreso. Texto inválido");
		} else {
			Course course = new Course(courseName);
			int inserted = CoursesDAO.insert(course, con);
			if (inserted == 1) {
				System.out.println("Curso ingresado exitosamente");
			} else {
				showError("Error de ingreso");
			}
		}
	}

	private static void viewCourses(Connection con) throws SQLException {
		showTitle("Lista de Cursos");
		List<Course> coursesList = CoursesDAO.findAll(con);
		showSubtitle("Id | Curso");
		coursesList.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

	private static boolean validateStringLength(String text) {
		boolean notValid = text.length() < MIN_CHAR || text.length() > MAX_CHAR;
		return notValid;
	}

	private static int showCoursesSubmenu(Scanner scan) {
		showTitle("Menú Curso");
		System.out.println("1 - Nuevo Curso");
		System.out.println("2 - Ver Cursos");
		System.out.println("3 - Modificar Curso");
		System.out.println("4 - Eliminar Curso");
		System.out.println("5 - Buscar Curso por Nombre");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static int showMenu(Scanner scan) {
		showTitle("Menú Principal");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos");
		System.out.println("3 - Profesores");
		System.out.println("4 - Inscripciones");
		System.out.println("0 - Salir");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static void showError(String text) {
		System.out.println(" *** " + text + " *** ");
	}

	private static void showSubtitle(String text) {
		System.out.println();
		System.out.println(text);
		System.out.println("-------------------------------------");
	}

	private static void showTitle(String text) {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println(text);
		System.out.println("-------------------------------------");
	}
}
