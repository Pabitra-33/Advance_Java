package testjdbcjava.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataToDatabase {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection con;
	public static void main(String[] args) throws SQLException {
		try {
			//1st step: Loading and registering driver software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing connection between java program and database
			con = DriverManager.getConnection(url, user, password);
			
			//3rd step: Create Statement
			Statement stm = con.createStatement();
			
			//Query
			String sql = "INSERT into student values(106,'Amaran',25)";
			
			//4th step: Execute Query
			stm.execute(sql);
			System.out.println("Data inserted successfully...!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//5th step: close the connection
			con.close();
		}
	}
}