package inicio.db.inicio2.model;

public class Teacher {

	private int idTeacher;
	private String tName;
	private String tLastName;
	private String tEmail;
	private String specialty;

	public Teacher(String teacherName, String teacherLName) {
		this.tName = teacherName;
		this.tLastName = teacherLName;
	}

	public Teacher(String teacherName, String teacherLName, String teacherEmail, String teacherSpecialty) {
		this.tName = teacherName;
		this.tLastName = teacherLName;
		this.tEmail = teacherEmail;
		this.specialty = teacherSpecialty;
	}

	public Teacher(int idTeacher, String teacherName, String teacherLName) {
		this.idTeacher = idTeacher;
		this.tName = teacherName;
		this.tLastName = teacherLName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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
