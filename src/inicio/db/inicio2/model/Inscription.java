package inicio.db.inicio2.model;

public class Inscription {

	private int idInsc;
	private String commission;
	private int partialNote;
	private int finalNote;
	private int status; // 1 = activo / 0 = cancelado

	private Course course;
	private Student student;
	private Teacher teacher;

	public Inscription(Student student, Course course, Teacher teacher) {
		this.student = student;
		this.course = course;
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
}
