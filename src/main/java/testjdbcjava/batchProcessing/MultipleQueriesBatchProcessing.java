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
			String iQuery = "INSERT into student values(106,'Ankita',23)";
			String uQuery = "Update student set name='Niroj' where id=105";
			String dQuery = "DELETE from student where id=101";
			
			//3rd step: create Statement(PreparedStatement)
			Statement stm = conn.createStatement();
			stm.addBatch(iQuery);
			stm.addBatch(uQuery);
			stm.addBatch(dQuery);
			
			//4th step: Execute Query
			int[] arr = stm.executeBatch();
			System.out.println(arr.length);
			System.out.println("Successfully operation performed in database..!");
			
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
