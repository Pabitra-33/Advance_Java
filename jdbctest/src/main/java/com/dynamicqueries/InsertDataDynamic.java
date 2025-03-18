package com.dynamicqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataDynamic {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";//database credentials
 	private static String password = "123";
 	
 	//main method
 	public static void main(String[] args) {
 		
 		try {
 			//1st step: Load & Register Driver Software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step: Establishing connection
 			Connection conn = DriverManager.getConnection(url, user, password);
 			
 			//String query
 			String query = "INSERT into student values(?,?,?)";
 			
 			//3rd step: create Statement(PreparedStatement)
 			PreparedStatement pstm = conn.prepareStatement(query);
 			pstm.setInt(1, 100);
 			pstm.setString(2, "Raveesh");
 			pstm.setInt(3, 27);
 			
 			//4th step: Execute Query
 			pstm.execute();
 			System.out.println("Data Saved to database");
 			
 			//5th step: close the connection
 			conn.close();
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
}
