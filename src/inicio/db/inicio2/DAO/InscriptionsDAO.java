package inicio.db.inicio2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import inicio.db.inicio2.model.Course;
import inicio.db.inicio2.model.Inscription;
import inicio.db.inicio2.model.Student;
import inicio.db.inicio2.model.Teacher;

public class InscriptionsDAO {

	public static int insert(Inscription inscription, Connection con) throws SQLException {
		String sql = "INSERT INTO inscriptions (id_student, id_course, id_teacher) VALUES (?, ?, ?)";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, inscription.getStudent().getIdStudent());
		prepStmt.setInt(2, inscription.getCourse().getIdCourse());
		prepStmt.setInt(3, inscription.getTeacher().getIdTeacher());
		return prepStmt.executeUpdate();
	}

	public static List<Inscription> findAll(Connection con) throws SQLException {
		List<Inscription> inscriptionsList = new ArrayList<Inscription>();
		String sql = "SELECT i.idInsc, s.idStud, s.sName, s.sLastName, c.idCourse, c.cName, t.idTeacher, t.tName, t.tLastName FROM inscriptions i, students s, courses c, teachers t WHERE i.id_teacher = t.idTeacher AND i.id_student = s.idStud AND i.id_course = c.idCourse ORDER BY i.idInsc";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			int idInsc = resultSet.getInt(1);
			Student student = new Student(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
			Course course = new Course(resultSet.getInt(5), resultSet.getString(6));
			Teacher teacher = new Teacher(resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));
			Inscription inscription = new Inscription(student, course, teacher);
			inscription.setIdInsc(idInsc);
			inscriptionsList.add(inscription);
		}
		return inscriptionsList;
	}

	public static int update(Inscription inscription, Connection con) throws SQLException {
		String sql = "UPDATE inscriptions SET id_course = ? WHERE id_student = ?  AND idInsc = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, inscription.getCourse().getIdCourse());
		prepStmt.setInt(2, inscription.getStudent().getIdStudent());
		prepStmt.setInt(3, inscription.getIdInsc());
		return prepStmt.executeUpdate();
	}

	// UPDATE inscriptions SET id_course = 1 WHERE id_student = 2 AND idInsc = 1;
}
