package testjdbcjava.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TraineeService {
	private static String url = "jdbc:postgresql://localhost:5432/jspider?user=postgres&password=123";
	static Connection con;
	
	//static block
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
