package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTestBatchExecution {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";//db credentials
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
			pstm.setInt(1, 1007);
			pstm.setString(2, "Ankita");
			pstm.setInt(3, 26);
			pstm.addBatch();
			pstm.setInt(1, 1000);
			pstm.setString(2, "Rahul");
			pstm.setInt(3, 28);
//			int[] res = pstm.executeBatch();
			pstm.executeBatch();
//			System.out.println(Arrays.toString(res));
			
			//4th step: Execute Query
			boolean res = pstm.execute();
			if(res != true) {
				System.out.println("Successfully inserted data to database..!");
			}
			
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
