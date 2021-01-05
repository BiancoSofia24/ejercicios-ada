package inicio.db.inicio2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import inicio.db.inicio2.model.Student;

public class StudentsDAO {

	public static int insert(Student student, Connection con) throws SQLException {
		String sql = "INSERT INTO students (sName, sLastName, sEmail) VALUES (?, ?, ?)";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setString(1, student.getsName());
		prepStmt.setString(2, student.getsLastName());
		prepStmt.setString(3, student.getsEmail());
		return prepStmt.executeUpdate();
	}

	public static List<Student> findAll(Connection con) throws SQLException {
		List<Student> studentsList = new ArrayList<Student>();
		String sql = "SELECT * FROM students s";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			int idStud = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			String studentLName = resultSet.getString(3);
			String studentEmail = resultSet.getString(4);
			Student student = new Student(studentName, studentLName, studentEmail);
			student.setIdStudent(idStud);
			studentsList.add(student);
		}
		return studentsList;
	}

	public static int update(Student student, Connection con) throws SQLException {
		String sql = "UPDATE students SET sName = ?, sLastName = ?, sEmail = ? WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setString(1, student.getsName());
		prepStmt.setString(2, student.getsLastName());
		prepStmt.setString(3, student.getsEmail());
		prepStmt.setInt(4, student.getIdStudent());
		return prepStmt.executeUpdate();
	}

	public static int delete(int idStudent, Connection con) throws SQLException {
		String sql = "DELETE FROM students WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, idStudent);
		return prepStmt.executeUpdate();
	}

	public static Student findById(int idStud, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName, s.sEmail FROM students s WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, idStud);
		ResultSet resultSet = prepStmt.executeQuery();
		Student student = null;
		if (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
		}
		return student;
	}

	public static List<Student> findByName(String studentName, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName, s.sEmail FROM students s WHERE s.sName LIKE '%" + studentName
				+ "%' ORDER BY s.sName";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		List<Student> studentsList = new ArrayList<Student>();
		Student student = null;
		while (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
			studentsList.add(student);
		}
		return studentsList;
	}

	public static List<Student> findByLastName(String studentLName, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName, s.sEmail FROM students s WHERE s.sLastName LIKE '%" + studentLName
				+ "%' ORDER BY s.sLastName";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		List<Student> studentsList = new ArrayList<Student>();
		Student student = null;
		while (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
			studentsList.add(student);
		}
		return studentsList;
	}
}
