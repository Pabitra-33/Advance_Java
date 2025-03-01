package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OneArgConnectionMethod {
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres?password=123";
	static Connection conn;//Connection reference
	
	//main method
	public static void main(String[] args) throws SQLException {
	
		try {
			//1st step: Load & Register Driver Software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing connection
			conn = DriverManager.getConnection(url);
			
			//String query
			
			
			//3rd step: create Statement(PreparedStatement)
			
			
			
			//4th step: Execute Query
			
			System.out.println("Successfully data inserted in database..!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//5th step: close the connection
			conn.close();
			System.out.println("Connection Closed");
		}
	}
}