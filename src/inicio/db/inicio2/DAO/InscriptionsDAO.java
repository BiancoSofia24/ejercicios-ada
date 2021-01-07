package inicio.db.inicio2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import inicio.db.inicio2.model.Inscription;

public class InscriptionsDAO {

	// Error for insert method
	public static int insert(Inscription inscription, Connection con) throws SQLException {
		String sql = "INSERT INTO inscriptions (id_student, id_course, id_teacher, status) VALUES (?, ?, ?, ?)";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, inscription.getStudent().getIdStudent());
		prepStmt.setInt(2, inscription.getCourse().getIdCourse());
		prepStmt.setInt(3, inscription.getTeacher().getIdTeacher());
		prepStmt.setString(4, inscription.getStatus());
		return prepStmt.executeUpdate();
	}

	public static List<Inscription> findAll(Connection con) throws SQLException {
		List<Inscription> inscriptionsList = new ArrayList<Inscription>();
		String sql = "SELECT * FROM inscriptions ORDER BY idInsc";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			int idInsc = resultSet.getInt(1);
			Inscription inscription = new Inscription(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4),
					resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8));
			inscription.setIdInsc(idInsc);
			inscriptionsList.add(inscription);
		}
		return inscriptionsList;
	}

	// Modify
	public static int update(Inscription inscription, Connection con) throws SQLException {
		String sql = "UPDATE inscriptions SET id_course = ? WHERE id_student = ?  AND idInsc = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, inscription.getCourse().getIdCourse());
		prepStmt.setInt(2, inscription.getStudent().getIdStudent());
		prepStmt.setInt(3, inscription.getIdInsc());
		return prepStmt.executeUpdate();
	}

}
