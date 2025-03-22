package com.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
 			String dQuery = "DELETE from teacher where id = ?";
 			
 			//3rd step: create Statement(PreparedStatement)
 			Statement stm = conn.createStatement();
 			stm.addBatch(uQuery);
 			stm.addBatch(dQuery);
 			stm.executeBatch();
 			
 			//4th step: Execute Query
 			stm.execute(uQuery);
 			stm.execute(dQuery);
 			System.out.println("Successfully updated data to database..!");
 			
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
