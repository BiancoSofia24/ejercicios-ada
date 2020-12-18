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
		String sql = "INSERT INTO students (sName, sLastName) VALUES (?, ?)";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setString(1, student.getsName());
		prepStmt.setString(2, student.getsLastName());
		return prepStmt.executeUpdate();
	}

	public static List<Student> findAll(Connection con) throws SQLException {
		List<Student> studentsList = new ArrayList<Student>();
		String sql = "SELECT s.idStud, s.sName, s.sLastName FROM students s";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			int idStud = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			String studentLastName = resultSet.getString(3);
			Student student = new Student(studentName, studentLastName);
			student.setIdStudent(idStud);
			studentsList.add(student);
		}
		return studentsList;
	}

	public static int update(Student student, Connection con) throws SQLException {
		String sql = "UPDATE students SET sName = ?, sLastName = ? WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setString(1, student.getsName());
		prepStmt.setString(2, student.getsLastName());
		prepStmt.setInt(3, student.getIdStudent());
		return prepStmt.executeUpdate();
	}

	public static int delete(int idStud, Connection con) throws SQLException {
		String sql = "DELETE FROM students WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, idStud);
		return prepStmt.executeUpdate();
	}

	public static Student findById(int idStud, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName FROM students s WHERE idStud = ?";
		PreparedStatement prepStmt = con.prepareStatement(sql);
		prepStmt.setInt(1, idStud);
		ResultSet resultSet = prepStmt.executeQuery();
		Student student = null;
		if (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2));
		}
		return student;
	}

	public static List<Student> findByName(String studentName, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName FROM students s WHERE s.sName LIKE '%" + studentName
				+ "%' ORDER BY s.sName";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		List<Student> studentList = new ArrayList<Student>();
		Student student = null;
		while (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2));
			studentList.add(student);
		}
		return studentList;
	}

	public static List<Student> findByLastName(String studentLName, Connection con) throws SQLException {
		String sql = "SELECT s.sName, s.sLastName FROM students s WHERE s.sLastName LIKE '%" + studentLName
				+ "%' ORDER BY s.sLastName";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		List<Student> studentList = new ArrayList<Student>();
		Student student = null;
		while (resultSet.next()) {
			student = new Student(resultSet.getString(1), resultSet.getString(2));
			studentList.add(student);
		}
		return studentList;
	}
}