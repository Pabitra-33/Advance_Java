package jdbctest.crudoperaation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataFromDatabase {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";
 	private static String password = "123";
 	
 	//main method
 	public static void main(String[] args) {
 		
 		try {
 			//1st step: Load & register Driver software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step : Establishing connection
 			Connection conn = DriverManager.getConnection(url, user, password);
 			
 			//3rd step: create Statement
 			Statement stmt = conn.createStatement();
 			
 			//Query
 			String sql = "SELECT * FROM student";
 			
 			//4th step: Execute Query
 			ResultSet rs = stmt.executeQuery(sql);
 			while(rs.next()) {
 				System.out.println(rs.getInt(1));
 				System.out.println(rs.getString(2));
 				System.out.println(rs.getInt(3));
 				System.out.println("==============");
 			}
 			
 			//5th step: Close the connection
 			conn.close();
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
}
