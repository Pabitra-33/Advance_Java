package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OneArgConnectionMethod {
	//we will differentiate the database credentials and url by delimiter
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	static Connection con;
	static String query = "INSERT into student values(105,'Bhabna',25)";
	
	public static void main(String[] args) throws SQLException {
		try {
			//1st step
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Class Loaded");
			
			//2nd step
			con = DriverManager.getConnection(url);
			System.out.println("Connection Established");
			
			//3rd step
			Statement stm = con.createStatement();
			
			//4th step
			stm.execute(query);
			System.out.println("Data inserted Successfully..!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//5th step
			con.close();
			System.out.println("Connection Closed");
		}
	}
}