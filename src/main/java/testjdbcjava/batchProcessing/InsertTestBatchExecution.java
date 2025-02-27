package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTestBatchExecution {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection conn;//Connection reference
	
	//main method
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		try {
			//1st step: Load & Register Driver Software
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Software Loaded");
			
			//2nd step: Establishing connection
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			
			//String query
			String query = "INSERT into teacher values(?,?,?)";
			
			//3rd step: create Statement(PreparedStatement)
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, 105);
			pstm.setString(2, "Ramana");
			pstm.setInt(3, 25);
			pstm.addBatch();
			pstm.setInt(1, 106);
			pstm.setString(2, "Dhruva");
			pstm.setInt(3, 28);
			pstm.executeBatch();
			
			//4th step: Execute Query
			pstm.execute();
			System.out.println("Successfully inserted data to database..!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
			//5th step: close the connection
			conn.close();
		}
	}
}
