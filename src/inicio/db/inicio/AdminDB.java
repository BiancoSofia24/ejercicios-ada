package inicio.db.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDB {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Path in jar file com/mysql/jdbc/Driver or com/mysql/cj/jdbc/Driver
		// Class.forName("com.mysql.jbdc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		// getConnection(<jdbc::mysql::host:port/db>, <user>, <pass>);
		// useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ada_course?serverTimezone=UTC", "root", "");
	}

}
