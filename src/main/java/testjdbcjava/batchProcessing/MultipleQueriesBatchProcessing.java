package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MultipleQueriesBatchProcessing {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection conn;//Connection reference
	
	//main method
	public static void main(String[] args) throws SQLException {
	
		try {
			//1st step: Load & Register Driver Software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing connection
			conn = DriverManager.getConnection(url, user, password);
			
			//String query
			String uQuery = "Update teacher set name = Ankita where id = 103";
			String dQuery = "DELETE from teacher where id = 106";
			
			//3rd step: create Statement(PreparedStatement)
			Statement stm = conn.createStatement();
			stm.addBatch(uQuery);
			stm.addBatch(dQuery);
			stm.executeBatch();
			
			//4th step: Execute Query
			stm.executeUpdate(dQuery);
			System.out.println("Successfully data updated in database..!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			//5th step: close the connection
			conn.close();
			System.out.println("Connection Closed");
		}
	}
}
