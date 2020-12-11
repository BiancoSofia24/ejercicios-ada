package inicio.db.inicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AppJDBC {

	public static void main(String[] args) {
		System.out.println("Mis Cursos");
		System.out.println("-----------------------------------");

		try {
			Connection con = AdminDB.getConnection();
			Scanner scan = new Scanner(System.in);
			int opt = optionsMenu(scan);
			int optAlumn;
			int optCourse;
			int optInsc;
			while (opt != 0) {
				switch (opt) {
				case 1:
					optAlumn = alumnsMenu(scan);
					alumnOptions(optAlumn, scan, con);
					opt = optionsMenu(scan);
					break;
				case 2:
					optCourse = coursesMenu(scan);
					coursesOptions(optCourse, scan, con);
					opt = optionsMenu(scan);
					break;
				case 3:
					optInsc = inscriptionsMenu(scan);
					inscriptionsOptions(optInsc, scan, con);
					opt = optionsMenu(scan);
					break;
				}
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void viewInscriptions(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "SELECT i.id, a.name, a.lastName, c.name FROM inscriptions i, alumns a, course_1 c WHERE i.id_alumn = a.id AND i.id_course = c.id";
		ResultSet resultSet = stmt.executeQuery(sql);
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Lista de Inscripciones");
		System.out.println("-------------------");
		while (resultSet.next()) {
			int idInsc = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String lastName = resultSet.getString(3);
			String course = resultSet.getString(4);
			System.out.println(idInsc + " | " + name + "  " + lastName + " | " + course);
		}
	}

	private static void newInscription(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Nueva Inscripción");
		System.out.println("-------------------");
		System.out.print("Ingrese id del Alumno -> ");
		int idAlumn = scan.nextInt();
		System.out.print("Ingrese id del Curso -> ");
		int idCourse = scan.nextInt();
		String sql = "INSERT INTO inscriptions (id_alumn, id_course) VALUES ('" + idAlumn + "', '" + idCourse + "')";
		int insert = stmt.executeUpdate(sql);
		if (insert == 1) {
			System.out.println("Inscripcion realizada");
		} else {
			System.out.println("Hubo un error en la inscripción");
		}
	}

	private static void inscriptionsOptions(int opt, Scanner scan, Connection con) throws SQLException {
		while (opt != 0) {
			switch (opt) {
			case 1:
				newInscription(scan, con);
				break;
			case 2:
				viewInscriptions(con);
				break;
			case 3:
				System.out.println();
				System.out.println("opt 3");
				break;
			case 4:
				System.out.println();
				System.out.println("opt 4");
				break;
			}
			opt = inscriptionsMenu(scan);
		}
	}

	private static int inscriptionsMenu(Scanner scan) {
		System.out.println();
		System.out.println("Menú Inscripciones");
		System.out.println("-------------------");
		System.out.println("1 - Inscribir");
		System.out.println("2 - Ver Inscripciones");
		System.out.println("3 - Modificar Inscripción");
		System.out.println("4 - Dar de baja");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static void deleteAlumn(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Eliminar Alumno");
		System.out.println("-------------------");
		System.out.print("Ingrese id del alumno a eliminar -> ");
		int id = scan.nextInt();
		String sql = "SELECT a.name, a.lastName FROM alumns a WHERE id = " + id + "";
		ResultSet resultSet = stmt.executeQuery(sql);
		if (resultSet.next()) {
			String name = resultSet.getString(1);
			String lastName = resultSet.getString(2);
			System.out.println("Alumno: " + name + " " + lastName);
		}
		System.out.println();
		System.out.print("¿Está seguro de eliminar este alumno? y/n -> ");
		String opt = scan.next();
		if (opt.toUpperCase().equals("Y")) {
			sql = "DELETE FROM alumns WHERE id = " + id + "";
			int deleted = stmt.executeUpdate(sql);
			if (deleted == 1) {
				System.out.println("Registro eliminado");
			} else {
				System.out.println("Registro inexistente");
			}
		} else if (opt.toUpperCase().equals("N")) {
			System.out.println("Registro no eliminado");
		}
	}

	private static void updateAlumn(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.print("Ingrese id del alumno a modificar -> ");
		int id = scan.nextInt();
		String sql = "SELECT a.name, a.lastName FROM alumns a WHERE id = " + id + "";
		ResultSet resultSet = stmt.executeQuery(sql);
		if (resultSet.next()) {
			String name = resultSet.getString(1);
			String lastName = resultSet.getString(2);
			System.out.println("Alumno: " + name + " " + lastName);
		}
		System.out.println();
		System.out.println("Ingrese nuevos datos del alumno");
		System.out.print("Nombre -> ");
		String name = scan.next();
		System.out.print("Apellido -> ");
		String lastName = scan.next();
		sql = "UPDATE alumns SET name = '" + name + "', lastName = '" + lastName + "' WHERE id = " + id + "";
		stmt.executeUpdate(sql);
		System.out.println("Alumno modificado exitosamente");
	}

	private static void viewAlumns(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM alumns";
		ResultSet resultSet = stmt.executeQuery(sql);
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Lista de Alumnos");
		System.out.println("-------------------");
		while (resultSet.next()) {
			int idAlumn = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String lastName = resultSet.getString(3);
			System.out.println(idAlumn + " | " + name + " | " + lastName);
		}
	}

	private static void newAlumn(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Nuevo Alumno");
		System.out.println("-------------------");
		System.out.print("Ingrese nombre del Alumno -> ");
		String name = scan.next();
		System.out.print("Ingrese apellido del Alumno -> ");
		String lastName = scan.next();
		String sql = "INSERT INTO alumns (name, lastName) VALUES ('" + name + "', '" + lastName + "')";
		stmt.executeUpdate(sql);
		System.out.println("Alumno ingresado exitosamente");
	}

	private static void alumnOptions(int opt, Scanner scan, Connection con) throws SQLException {
		while (opt != 0) {
			switch (opt) {
			case 1:
				newAlumn(scan, con);
				break;
			case 2:
				viewAlumns(con);
				break;
			case 3:
				updateAlumn(scan, con);
				break;
			case 4:
				deleteAlumn(scan, con);
				break;
			}
			opt = alumnsMenu(scan);
		}
	}

	private static int alumnsMenu(Scanner scan) {
		System.out.println();
		System.out.println("Menú Alumnos");
		System.out.println("-------------------");
		System.out.println("1 - Nuevo Alumno");
		System.out.println("2 - Ver Alumnos");
		System.out.println("3 - Modificar Alumno");
		System.out.println("4 - Eliminar Alumno");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static void deleteCourse(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Eliminar Curso");
		System.out.println("-------------------");
		System.out.print("Ingrese id del curso a eliminar -> ");
		int id = scan.nextInt();
		String sql = "SELECT c.name FROM course_1 c WHERE id = " + id + "";
		ResultSet resultSet = stmt.executeQuery(sql);
		if (resultSet.next()) {
			String course = resultSet.getString(1);
			System.out.println("Curso: " + course);
		}
		System.out.println();
		System.out.print("¿Está seguro de eliminar este curso? y/n -> ");
		String opt = scan.next();
		if (opt.toUpperCase().equals("Y")) {
			sql = "DELETE FROM course_1 WHERE id = " + id + "";
			int deleted = stmt.executeUpdate(sql);
			if (deleted == 1) {
				System.out.println("Registro eliminado");
			} else {
				System.out.println("Registro inexistente");
			}
		} else if (opt.toUpperCase().equals("N")) {
			System.out.println("Registro no eliminado");
		}
	}

	private static void updateCourse(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Modificar Curso");
		System.out.println("-------------------");
		System.out.print("Ingrese id del curso a modificar -> ");
		int id = scan.nextInt();
		String sql = "SELECT c.name FROM course_1 c WHERE id = " + id + "";
		ResultSet resultSet = stmt.executeQuery(sql);
		if (resultSet.next()) {
			String course = resultSet.getString(1);
			System.out.println("Curso: " + course);
		}
		System.out.println();
		System.out.print("Ingrese nuevo nombre del curso -> ");
		String name = scan.next();
		sql = "UPDATE course_1 SET name = '" + name + "' WHERE id = " + id + "";
		stmt.executeUpdate(sql);
		System.out.println("Curso modificado exitosamente");
	}

	private static void viewCourses(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM course_1";
		ResultSet resultSet = stmt.executeQuery(sql);
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Lista de Cursos");
		System.out.println("-------------------");
		while (resultSet.next()) {
			int idCourse = resultSet.getInt(1);
			String course = resultSet.getString(2);
			System.out.println(idCourse + " | " + course);
		}
	}

	private static void newCourse(Scanner scan, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("Nuevo Curso");
		System.out.println("-------------------");
		System.out.println();
		System.out.print("Ingrese nombre del curso -> ");
		String course = scan.next();
		String sql = "INSERT INTO course_1 (name) VALUES ('" + course + "')";
		stmt.executeUpdate(sql);
		System.out.println("Curso ingresado exitosamente");
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
			opt = coursesMenu(scan);
		}
	}

	private static int coursesMenu(Scanner scan) {
		System.out.println();
		System.out.println("Menú Cursos");
		System.out.println("-------------------");
		System.out.println("1 - Nuevo Curso");
		System.out.println("2 - Ver Cursos");
		System.out.println("3 - Modificar Curso");
		System.out.println("4 - Eliminar Curso");
		System.out.println("0 - Ir Atrás");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static int optionsMenu(Scanner scan) {
		System.out.println();
		System.out.println("Menú Principal");
		System.out.println("-------------------");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos");
		System.out.println("3 - Inscripciones");
		System.out.println("0 - Salir");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
