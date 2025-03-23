package com.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDataBatchProcessing {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";//database credentials
 	private static String password = "123";
 	static Connection conn;//Connection reference
 	
 	//main method
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		System.out.println("Enter the teacher id: ");
 		int tid = sc.nextInt();
 		System.out.println("Enter the teacher name: ");
 		String tname = sc.next();
 		sc.nextLine();
 		
 		try {
 			//1st step: Load & Register Driver Software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step: Establishing connection
 			conn = DriverManager.getConnection(url, user, password);
 			
 			//String query
 			String uQuery = "Update teacher set name = ? where id = ?";
 			
 			//3rd step: create Statement(PreparedStatement)
 			PreparedStatement pstm = conn.prepareStatement(uQuery);
 			pstm.setString(1, tname);
 			pstm.setInt(2, tid);
 			pstm.addBatch();
 			pstm.executeBatch();
 			
 			//4th step: Execute Query
 			int res = pstm.executeUpdate();
 			if(res != 0) {
 				System.out.println("Successfully updated data to database..!");
 			}
 			else {
 				System.out.println("Data not updated in the database");
 			}
 			
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		finally {
 			sc.close();
 			//5th step: close the connection
 			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
 		}
 	}
}
