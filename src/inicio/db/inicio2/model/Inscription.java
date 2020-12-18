package inicio.db.inicio2.model;

public class Inscription {

	private int idInsc;
	private int idStudent;
	private int idCourse;
	private Course course;
	private Student student;

	public Inscription(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public Inscription(int idStudent, int idCourse) {
		this.idStudent = idStudent;
		this.idCourse = idCourse;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getIdInsc() {
		return idInsc;
	}

	public void setIdInsc(int idInsc) {
		this.idInsc = idInsc;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

}
