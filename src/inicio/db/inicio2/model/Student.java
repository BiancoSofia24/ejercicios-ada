package inicio.db.inicio2.model;

public class Student {

	private int idStud;
	private String sName;
	private String sLastName;

	public Student(String studentName, String studentLastName) {
		this.sName = studentName;
		this.sLastName = studentLastName;
	}

	public int getIdStud() {
		return idStud;
	}

	public void setIdStud(int idStud) {
		this.idStud = idStud;
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
