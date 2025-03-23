package com.dynamicqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestExecuteMethods {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";
 	private static String password = "123";
 	static Connection conn;
 	//main method
 	public static void main(String[] args) {
 		try {
 			//1st step: Load & Register Driver Software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step: Establishing connection
 			conn = DriverManager.getConnection(url, user, password);
 			
 			//String query
 			String query = "INSERT into student values(?,?,?)";
 			
 			//3rd step: create Statement(PreparedStatement)
 			PreparedStatement pstm = conn.prepareStatement(query);
 			pstm.setInt(1, 107);
 			pstm.setString(2, "Chandan");
 			pstm.setInt(3, 22);
 			
 			//4th step: Execute Query
 			//boolean res = pstm.execute();//returns true for select queries and false for non-select queries.
 			//pstm.executeQuery();//CTE: used only for the Select Queries
 			int res = pstm.executeUpdate();//returns 1 for data affect in the table, else returns 0.
 			System.out.println(res);
 			
 			
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		finally {
 			//5th step: close the connection
 			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
 	}
}
