package com.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataBatchProcessing {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";
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
 		System.out.println("Enter the teacher age: ");
 		int tage = sc.nextInt();
 		
 		try {
 			//1st step: Load & Register Driver Software
 			Class.forName("org.postgresql.Driver");
 			
 			//2nd step: Establishing connection
 			conn = DriverManager.getConnection(url, user, password);
 			
 			//String query
 			String query = "INSERT into teacher values(?,?,?)";
 			
 			//3rd step: create Statement(PreparedStatement)
 			PreparedStatement pstm = conn.prepareStatement(query);
 			pstm.setInt(1, tid);
 			pstm.setString(2, tname);
 			pstm.setInt(3, tage);
 			pstm.addBatch();
 			pstm.executeBatch();
 			
 			//4th step: Execute Query
 			pstm.execute();
 			System.out.println("Successfully inserted data to database..!");
 			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
 	}
}
