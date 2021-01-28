package inicio.db.inicio2.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import inicio.db.inicio2.DAO.CoursesDAO;
import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.utils.Util;

public class CoursesHelper {

	public static void showList(List<Course> list) {
		Util.showSubtitle("Id | Curso");
		list.forEach((item) -> {
			System.out.println(item.getIdCourse() + " | " + item.getcName());
		});
	}

	public static void insert(Course course, Connection con) throws SQLException {
		int inserted = CoursesDAO.insert(course, con);
		if (inserted == 1) {
			System.out.println("Registro creado exitosamente");
		} else {
			Util.showError("Error de ingreso");
		}
	}

	public static void update(Course course, Connection con) throws SQLException {
		int updated = CoursesDAO.update(course, con);
		if (updated == 1) {
			System.out.println("Registro editado exitosamente");
		} else {
			Util.showError("Error en la edici�n de registro");
		}
	}

	public static void delete(int idCourse, Connection con) throws SQLException {
		int deleted = CoursesDAO.delete(idCourse, con);
		if (deleted == 1) {
			System.out.println("Registro eliminado");
		} else {
			Util.showError("Registro inexistente");
		}
	}

}
