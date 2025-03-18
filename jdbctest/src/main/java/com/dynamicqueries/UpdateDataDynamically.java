package com.dynamicqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataDynamically {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";
 	private static String password = "123";
 	static Connection con;
 	
 	//main method
 	public static void main(String[] args) {
 		try {
 			//1st step: Load and Register Driver Software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step: Establishing Connection
 			con = DriverManager.getConnection(url, user, password);
 			
 			//Query
 			String query = "UPDATE student set age = ? where id = ?";
 			
 			//3rd step: create statement
 			PreparedStatement pstm = con.prepareStatement(query);
 			pstm.setInt(1, 27);
 			pstm.setInt(2, 101);
 			
 			//4th step: Execute Query
 			pstm.execute();
 			System.out.println("Data updated successfully");
 			
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		finally {
 			try {
 				//5th step: close the connection
 				con.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
 	}
 }
