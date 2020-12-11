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
				}
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			stmt.executeUpdate(sql);
			System.out.println("Registro eliminado");
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
		System.out.println("Modificar Alumno");
		System.out.println("-------------------");
		System.out.print("Ingrese nombre del Alumno -> ");
		String name = scan.next();
		System.out.print("Ingrese apellido del Alumno -> ");
		String lastName = scan.next();
		String sql = "INSERT INTO alumns (name, lastName) VALUES ('" + name + "', '" + lastName + "')";
		stmt.executeUpdate(sql);
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
		System.out.println("0 - Ir Atras");
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
			stmt.executeUpdate(sql);
			System.out.println("Registro eliminado");
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
		System.out.print("Ingrese nombre del curso -> ");
		String course = scan.next();
		String sql = "INSERT INTO course_1 (name) VALUES ('" + course + "')";
		stmt.executeUpdate(sql);
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
		System.out.println("0 - Ir Atras");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

	private static int optionsMenu(Scanner scan) {
		System.out.println();
		System.out.println("Menú Principal");
		System.out.println("-------------------");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos");
		System.out.println("0 - Salir");
		System.out.print("Opción -> ");
		return scan.nextInt();
	}

}
