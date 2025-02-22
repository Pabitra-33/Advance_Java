package testjdbcjava.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataToDatabase {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	
	public static void main(String[] args) {
		try {
			//1st step: Loading and registering driver software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing connection
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3rd step: Create Statement
			Statement stm = con.createStatement();
			
			//Query
			String sql = "UPDATE student set age = 24 WHERE id = 105";
			
			//4th step: Execute Query
			stm.execute(sql);
			System.out.println("Data updated successfully...!");
			
			//5th step: close the connection
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
