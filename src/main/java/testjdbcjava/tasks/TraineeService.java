package testjdbcjava.tasks;

import java.sql.Connection;

public class TraineeService {
	private static String url = "jdbc:postgresql://localhost:5432/jspider?user=postgres&password=123";
	Connection con;
	
	//static block
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
