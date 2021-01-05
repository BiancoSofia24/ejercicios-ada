package inicio.db.inicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import inicio.db.inicio2.DAO.AdminDB;
import inicio.db.inicio2.controller.CourseController;
import inicio.db.inicio2.controller.InscriptionsController;
import inicio.db.inicio2.controller.StudentsController;
import inicio.db.inicio2.controller.TeachersController;
import inicio.db.inicio2.utils.Util;

public class AppJDBC {

	public static void main(String[] args) {
		Util.showTitle("Mis Cursos");
		try {
			Connection con = AdminDB.getConnection();
			Scanner scan = new Scanner(System.in);
			int option = showMenu(scan);
			while (option != 0) {
				switch (option) {
				case 1:
					students(scan, con);
					break;
				case 2:
					courses(scan, con);
					break;
				case 3:
					teachers(scan, con);
					break;
				case 4:
					inscriptions(scan, con);
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

	private static void inscriptions(Scanner scan, Connection con) throws SQLException {
		int crudOption = InscriptionsController.showInscriptionsSubmenu(scan);
		InscriptionsController.inscriptionsOptions(crudOption, scan, con);
	}

	private static void teachers(Scanner scan, Connection con) throws SQLException {
		int crudOption = TeachersController.showTeachersSubmenu(scan);
		TeachersController.teachersOptions(crudOption, scan, con);
	}

	private static void students(Scanner scan, Connection con) throws SQLException {
		int crudOption = StudentsController.showStudentsSubmenu(scan);
		StudentsController.studentsOptions(crudOption, scan, con);
	}

	private static void courses(Scanner scan, Connection con) throws SQLException {
		int crudOption = CourseController.showCoursesSubmenu(scan);
		CourseController.coursesOptions(crudOption, scan, con);
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
