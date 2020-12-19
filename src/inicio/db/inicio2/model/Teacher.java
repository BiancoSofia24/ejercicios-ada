package inicio.db.inicio2.model;

public class Teacher {

	private int idTeacher;
	private String tName;
	private String tLastName;

	public Teacher(String teacherName, String teacherLName) {
		this.tName = teacherName;
		this.tLastName = teacherLName;
	}

	public Teacher(int idTeacher, String teacherName, String teacherLName) {
		this.idTeacher = idTeacher;
		this.tName = teacherName;
		this.tLastName = teacherLName;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettLastName() {
		return tLastName;
	}

	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	public String toString() {
		return "Profesor: " + this.tName + " " + this.tLastName;
	}
}
