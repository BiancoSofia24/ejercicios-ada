package inicio.db.inicio2.model;

public class Student {

	private int idStudent;
	private String sName;
	private String sLastName;

	public Student(String studentName, String studentLastName) {
		this.sName = studentName;
		this.sLastName = studentLastName;
	}

	public Student(int idStudent, String studentName, String studentLastName) {
		this.idStudent = idStudent;
		this.sName = studentName;
		this.sLastName = studentLastName;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String toString() {
		return "Alumno: " + this.sName + " " + this.sLastName;
	}
}
