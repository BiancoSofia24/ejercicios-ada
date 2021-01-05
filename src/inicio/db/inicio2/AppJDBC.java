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
import inicio.db.inicio2.utils.Util;

public class AppJDBC {

	public static void main(String[] args) {
		Util.showTitle("Mis Cursos");
		try {
			Connection con = AdminDB.getConnection();
			Scanner scan = new Scanner(System.in);
			int option = showMenu(scan);
			int crudOption;
			while (option != 0) {
				switch (option) {
				case 1:
					crudOption = showStudentsSubmenu(scan);
					studentsOptions(crudOption, scan, con);
					break;
				case 2:
					crudOption = showCoursesSubmenu(scan);
					coursesOptions(crudOption, scan, con);
					break;
				case 3:
					crudOption = showTeachersSubmenu(scan);
					teachersOptions(crudOption, scan, con);
					break;
				case 4:
					crudOption = showInscriptionsSubmenu(scan);
					inscriptionsOptions(crudOption, scan, con);
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

	// Incomplete
	private static void inscriptionsOptions(int option, Scanner scan, Connection con) throws SQLException {
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
	private static void deleteInscription(Scanner scan, Connection con) throws SQLException {
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
	private static void updateInscription(Scanner scan, Connection con) throws SQLException {
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

	// Notes, commission and state is missing
	private static void viewInscriptions(Connection con) throws SQLException {
		Util.showTitle("Lista de Inscripciones");
		List<Inscription> inscriptionsList = InscriptionsDAO.findAll(con);
		Util.showSubtitle("Id | Alumno       | Curso    | Profesor");
		inscriptionsList.forEach((i) -> {
			System.out.println(i.getIdInsc() + " | " + i.getStudent().getsName() + " " + i.getStudent().getsLastName()
					+ " | " + i.getCourse().getcName() + " | " + i.getTeacher().gettName() + " "
					+ i.getTeacher().gettLastName());
		});
	}

	// Incomplete
	private static void newInscription(Scanner scan, Connection con) throws SQLException {
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
				System.out.print("Ingrese id del profesor -> ");
				int idTeacher = scan.nextInt();
				Teacher teacher = TeachersDAO.findById(idTeacher, con);
				if (teacher == null) {
					Util.showError("Registro inexistente");
				} else {
					System.out.println(teacher);
					System.out.println();
					System.out.print("¿Desea editar este curso? y/n -> ");
					String opt = scan.next();
					if (opt.toUpperCase().equals("Y")) {
						Inscription inscription = new Inscription(student, course, teacher);
						// Error!!
						int inserted = InscriptionsDAO.insert(inscription, con);
						if (inserted == 1) {
							System.out.println("Inscripcion realizada exitosamente");
						} else {
							Util.showError("Error al crear el registro");
						}
					} else if (opt.toUpperCase().equals("N")) {
						System.out.println("Registro no creado");
					}
				}
			}
		}

	}

	// Incomplete
	private static int showInscriptionsSubmenu(Scanner scan) {
		Util.showTitle("Menú Inscripciones");
		System.out.println("1 - Nueva Inscripción");
		System.out.println("2 - Ver Inscripciones por Alumnos");
		System.out.println("3 - Modificar Inscripción");
		System.out.println("4 - Eliminar Inscripción");
		System.out.println("5 - Buscar Alumnos por Curso"); // Alumno por curso
		System.out.println("6 - Buscar Alumno Inscrito"); // Curso por alumno
		System.out.println("7 - Ver Inscripciones por Notas");
		System.out.println("8 - Agregar Notas");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static void teachersOptions(int option, Scanner scan, Connection con) throws SQLException {
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
		Util.showTitle("Buscar Profesor por Apellido");
		System.out.print("Ingrese apellido del profesor: ");
		String teacherLName = scan.next();
		List<Teacher> teachersListByLastName = TeachersDAO.findByLastName(teacherLName, con);
		Util.showSubtitle("Apellido | Nombre");
		teachersListByLastName.forEach((t) -> {
			System.out.println(t.gettLastName() + " | " + t.gettName());
		});
	}

	private static void findTeacherByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Profesor por Nombre");
		System.out.print("Ingrese nombre del profesor: ");
		String teacherName = scan.next();
		List<Teacher> teachersListByName = TeachersDAO.findByName(teacherName, con);
		Util.showSubtitle("Nombre | Apellido");
		teachersListByName.forEach((t) -> {
			System.out.println(t.gettName() + " | " + t.gettLastName());
		});
	}

	private static void deleteTeacher(Scanner scan, Connection con) throws SQLException {
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

	private static void updateTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Profesor");
		System.out.print("Ingrese id del profesor registrado a modificar -> ");
		int idTeacher = scan.nextInt();
		Teacher actualTeacher = TeachersDAO.findById(idTeacher, con);
		if (actualTeacher == null) {
			Util.showError("Registro inexistente");
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
				if (Util.validateStringLength(teacherName) && Util.validateStringLength(teacherLName)) {
					Util.showError("Error de ingreso. Texto inválido");
				} else {
					Teacher teacher = new Teacher(teacherName, teacherLName);
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

	private static void newTeacher(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Profesor");
		System.out.print("Ingrese nombre del profesor -> ");
		String teachersName = scan.next();
		System.out.print("Ingrese apellido del profesor -> ");
		String teachersLastName = scan.next();
		if (Util.validateStringLength(teachersName) && Util.validateStringLength(teachersLastName)) {
			Util.showError("Error de ingreso. Texto inválido");
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

	private static void viewTeachers(Connection con) throws SQLException {
		Util.showTitle("Lista de Profesores");
		List<Teacher> teachersList = TeachersDAO.findAll(con);
		Util.showSubtitle("Id | Profesor");
		teachersList.forEach((t) -> {
			System.out.println(t.getIdTeacher() + " | " + t.gettName() + " " + t.gettLastName());
		});
	}

	private static int showTeachersSubmenu(Scanner scan) {
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

	private static void studentsOptions(int option, Scanner scan, Connection con) throws SQLException {
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
		Util.showTitle("Buscar Alumno por Apellido");
		System.out.print("Ingrese apellido del alumno: ");
		String studentLName = scan.next();
		List<Student> studentsListByLastName = StudentsDAO.findByLastName(studentLName, con);
		Util.showSubtitle("Apellido | Nombre     | Correo Electrónico");
		studentsListByLastName.forEach((s) -> {
			System.out
					.println(s.getsLastName() + " | " + s.getsName() + " | " + Util.valueForStringNull(s.getsEmail()));
		});
	}

	private static void findStudentByName(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Buscar Alumno por Nombre");
		System.out.print("Ingrese nombre del alumno: ");
		String studentName = scan.next();
		List<Student> studentsListByName = StudentsDAO.findByName(studentName, con);
		Util.showSubtitle("Nombre | Apellido    | Correo Electrónico");
		studentsListByName.forEach((s) -> {
			System.out
					.println(s.getsName() + " | " + s.getsLastName() + " | " + Util.valueForStringNull(s.getsEmail()));
		});
	}

	private static void deleteStudent(Scanner scan, Connection con) throws SQLException {
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

	private static void updateStudent(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Alumno");
		System.out.print("Ingrese id del alumno registrado a modificar -> ");
		int idStudent = scan.nextInt();
		Student actualStudent = StudentsDAO.findById(idStudent, con);
		if (actualStudent == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualStudent);
			System.out.println("Email: " + Util.valueForStringNull(actualStudent.getsEmail()));
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
						System.out.println("Alumno editado correctamente");
					} else {
						Util.showError("Error en la edición de registro");
					}
				}
			} else if (opt.toUpperCase().equals("N")) {
				System.out.println("Registro no editado");
			}
		}
	}

	private static void newStudent(Scanner scan, Connection con) throws SQLException {
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

	private static void viewStudents(Connection con) throws SQLException {
		Util.showTitle("Lista de Alumnos");
		List<Student> studentsList = StudentsDAO.findAll(con);
		Util.showSubtitle("Id | Alumno      | Correo Electrónico");
		studentsList.forEach((s) -> {
			System.out.println(s.getIdStudent() + " | " + s.getsName() + " " + s.getsLastName() + " | "
					+ Util.valueForStringNull(s.getsEmail()));
		});
	}

	private static int showStudentsSubmenu(Scanner scan) {
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
			case 5:
				findCourseByName(scan, con);
				break;
			}
			opt = showCoursesSubmenu(scan);
		}
	}

	private static void findCourseByName(Scanner scan, Connection con) throws SQLException {
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
			System.out.print("¿Esta seguro de eliminar este curso? y/n -> ");
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

	private static void updateCourse(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Modificar Curso");
		System.out.print("Ingrese id del curso a modificar -> ");
		int idCourse = scan.nextInt();
		Course actualCourse = CoursesDAO.findById(idCourse, con);
		if (actualCourse == null) {
			Util.showError("Registro inexistente");
		} else {
			System.out.println(actualCourse);
			System.out.println();
			System.out.print("¿Desea editar este curso? y/n -> ");
			String opt = scan.next();
			if (opt.toUpperCase().equals("Y")) {
				System.out.println();
				System.out.print("Ingrese nuevo nombre del curso -> ");
				String courseName = scan.next();
				if (Util.validateStringLength(courseName)) {
					Util.showError("Error de ingreso. Texto inválido");
				} else {
					Course course = new Course(courseName);
					course.setIdCourse(idCourse);
					int updated = CoursesDAO.update(course, con);
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

	private static void newCourse(Scanner scan, Connection con) throws SQLException {
		Util.showTitle("Nuevo Curso");
		System.out.print("Ingrese nombre del curso -> ");
		String courseName = scan.next();
		if (Util.validateStringLength(courseName)) {
			Util.showError("Error de ingreso. Texto inválido");
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

	private static void viewCourses(Connection con) throws SQLException {
		Util.showTitle("Lista de Cursos");
		List<Course> coursesList = CoursesDAO.findAll(con);
		Util.showSubtitle("Id | Curso");
		coursesList.forEach((c) -> {
			System.out.println(c.getIdCourse() + " | " + c.getcName());
		});
	}

	private static int showCoursesSubmenu(Scanner scan) {
		Util.showTitle("Menú Curso");
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
		Util.showTitle("Menú Principal");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos");
		System.out.println("3 - Profesores");
		System.out.println("4 - Inscripciones");
		System.out.println("0 - Salir");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
