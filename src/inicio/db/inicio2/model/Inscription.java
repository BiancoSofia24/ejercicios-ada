package inicio.db.inicio2.model;

public class Inscription {

	private int idInsc;
	private String commission;
	private int partialNote;
	private int finalNote;
	private String status; // 1 = activo / 0 = cancelado

	private Course course;
	private Student student;
	private Teacher teacher;

	public Inscription(Student student, Course course, Teacher teacher, String status) {
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.status = status;
	}

	public Inscription(Student student, Course course, Teacher teacher, String commission, int partialNote,
			int finalNote, String status) {
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.commission = commission;
		this.partialNote = partialNote;
		this.finalNote = finalNote;
		this.status = status;
	}

	public Inscription(int idInsc, Student student, Course course, Teacher teacher, String commission, int partialNote,
			int finalNote, String status) {
		this.idInsc = idInsc;
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.commission = commission;
		this.partialNote = partialNote;
		this.finalNote = finalNote;
		this.status = status;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public int getPartialNote() {
		return partialNote;
	}

	public void setPartialNote(int partialNote) {
		this.partialNote = partialNote;
	}

	public int getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
