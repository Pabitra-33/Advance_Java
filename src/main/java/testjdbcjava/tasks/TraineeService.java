package testjdbcjava.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TraineeService {
	private static String url = "jdbc:postgresql://localhost:5432/jspiders";
	private static String user = "postgres";
	private static String password = "123";
	static Connection con;
	static PreparedStatement pstm;
	Scanner sc = new Scanner(System.in);
	
	//static block
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}//static end
	
	//register trainee method
	public int register() {
		int result = 0;//creating a result array to store the data returned by the executeBatch method
		System.out.println("Please enter the below details to register:-");
		
		System.out.println("Enter how many records you want to insert: ");
		int input = sc.nextInt();
		
        String iQuery = "INSERT into trainee VALUES(?,?,?)";
		
		try {
			pstm = con.prepareStatement(iQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(input >= 1) {
			System.out.println("Enter the trainee id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter employee name: ");
			String name = sc.next();
			System.out.println("Enter employee age: ");
			int age = sc.nextInt();
			
			//adding to batch processing
			try {
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setInt(3, age);
				pstm.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			input--;
		}
		//handling the executeBatch method exception
		try {
			pstm.executeBatch();
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//update trainee method
	public int update() {
		int result = 0;//creating a result array to store the data returned by the executeBatch method
		System.out.println("Please enter the below details to update:-");
		
		System.out.println("Enter how many records you want to update: ");
		int input = sc.nextInt();
		
		String uQuery = "UPDATE trainee SET age = ? WHERE id = ?";
		
		while(input >= 1) {
			System.out.print("\nEnter age which you want to update: ");
			int age = sc.nextInt();
			System.out.print("Enter employee id, whose data you want to update: ");
			int id = sc.nextInt();
			
			try {
				PreparedStatement pstm = con.prepareStatement(uQuery);
				pstm.setInt(1, age);
				pstm.setInt(2, id);
				
				result = pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			input--;
		}
		//handling the executeBatch method exception
		try {
			pstm.executeBatch();
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//delete trainee method
	public int remove() {
		int res = 0;
		System.out.print("Enter employee id, whose data you want to delete: ");
		int id = sc.nextInt();
		
		String dQuery = "DELETE FROM trainee WHERE id = ?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(dQuery);
			pstm.setInt(1, id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//fetch trainee by age method
	public int getByAge() {
		String gaQuery = "SELECT * FROM trainee WHERE age = ?";
		return 0;
	}
	
	//fetch trainee by name method
	public int getByName() {
		String gnQuery = "SELECT * FROM trainee WHERE name = ?";
		
		return 0;
	}
	
	public boolean exit() {
		boolean flag = false;
		try {
			con.close();
			flag = true;
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
