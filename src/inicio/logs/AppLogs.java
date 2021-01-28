package inicio.logs;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class AppLogs {

	private static final String FORMAT_DATE = "yyyy-MM-dd";

	/*
	 * Generar un menu que lee datos de inscripcion (idCurso, idAlumno,
	 * idOperacion[inscripcion | cancalacion]) Escribir un archivo con la fecha y
	 * hora + los datos ingresados Segundo menu: generar un listado que lea el log
	 * generado con todas las transacciones del dia
	 */

	public static void main(String[] args) {
		System.out.println("Menu inscripcion");
		Scanner sc = new Scanner(System.in);
		int opcion = solicitarOpcion(sc);
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				incripcion(sc);
				break;
			case 2:
				cancelacion(sc);
				break;
			case 3:
				listado();
				break;
			case 4:
				listarEntreFechas(sc);
			}

			opcion = solicitarOpcion(sc);
		}

	}

	private static void listarEntreFechas(Scanner sc) {
		System.out.println("Ingrese fecha desde: (" + FORMAT_DATE + ")");
		String desde = sc.next();
		System.out.println("Ingrese fecha hasta: (" + FORMAT_DATE + ")");
		String hasta = sc.next();

		System.out.println("Fecha   Hora    Alumno  Curso  Accion");
		List<String> lineasLog = FileUtil.lecturaArchivo("src/inicio/logs/logs.txt");
		final String hastaDia = hasta + " 23:59:59";
		Stream<String> lineasFiltradas = lineasLog.stream()
				.filter(x -> x.compareTo(desde) >= 0 && x.compareTo(hastaDia) <= 0);
		lineasFiltradas.forEach(System.out::println);
	}

	private static void listado() {
		System.out.println("Fecha   Hora    Alumno  Curso  Accion");
		List<String> lineasLog = FileUtil.lecturaArchivo("src/inicio/logs/logs.txt");
		lineasLog.forEach(System.out::println);
	}

	private static void cancelacion(Scanner sc) {
		System.out.println("Cancelación:");
		System.out.println("Ingrese codigo de alumn@:");
		int alumno = sc.nextInt();
		System.out.println("Ingrese codigo de curso:");
		int curso = sc.nextInt();
		// escribir en archivo
		LogInscription log = new LogInscription(alumno, curso, Action.CANCELADO);
		FileUtil.escribir(log);

	}

	private static void incripcion(Scanner sc) {
		System.out.println("Incripcion:");
		System.out.println("Ingrese codigo de alumn@:");
		int alumno = sc.nextInt();
		System.out.println("Ingrese codigo de curso:");
		int curso = sc.nextInt();
		// escribir en archivo
		LogInscription log = new LogInscription(alumno, curso, Action.INSCRITO);
		FileUtil.escribir(log);

	}

	private static int solicitarOpcion(Scanner sc) {
		System.out.println();
		System.out.println("1. Inscripcion");
		System.out.println("2. Cancelación");
		System.out.println("3. Listado");
		System.out.println("4. Listado entre Fechas");
		System.out.println("0. Salir");
		return sc.nextInt();
	}

}
