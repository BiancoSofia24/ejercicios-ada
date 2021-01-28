package inicio.logs;

import java.util.Date;

public class LogInscription {
	private int alumno;
	private int curso;
	private Action accion;
	private Date fecha;

	public LogInscription(int alumno2, int curso2, Action accion) {
		this.alumno = alumno2;
		this.curso = curso2;
		this.accion = accion;
	}

	public LogInscription(Date fecha, int alumno2, int curso2, Action accion) {
		this.fecha = fecha;
		this.alumno = alumno2;
		this.curso = curso2;
		this.accion = accion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public Action getAccion() {
		return accion;
	}

	public void setAccion(Action accion) {
		this.accion = accion;
	}

	public String toString() {
		return String.format("%s %s %s", alumno, curso, accion);
	}
}
