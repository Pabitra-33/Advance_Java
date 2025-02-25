package testjdbcjava.dynamicqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDataDynamic {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection con;
	
	//main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the student age you want to change: ");
		int sage = scanner.nextInt();
		System.out.println("Enter the Student name whose data you want to update: ");
		String sname = scanner.next();
		
		try {
			//1st step: Load and Register Driver Software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing Connection
			con = DriverManager.getConnection(url, user, password);
			
			//Query
			//String query = "UPDATE student set id = ? where name = ?";
			String query = "UPDATE student set age = ? where name = ?";
			
			//3rd step: create statement
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, sage);
			pstm.setString(2, sname);
			
			//4th step: Execute Query
			pstm.execute();
			System.out.println("Data updated successfully..!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				scanner.close();
				//5th step: close the connection, it will throw SQL Exception
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
