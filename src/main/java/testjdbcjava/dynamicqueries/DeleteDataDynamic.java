package testjdbcjava.dynamicqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataDynamic {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection con;
	
	//main method
	public static void main(String[] args) throws SQLException {
		try {
			//1st step: Load & Register Driver Software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing Connection
			con = DriverManager.getConnection(url, user, password);
			
			//Query
			String query = "DELETE from student where id = ?";
			
			//3rd step: Creating prepared Statement
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 106);
			
			//4th step: execute query
			pstm.execute();
			System.out.println("Data deleted successfully...!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//5th step: close the connection
			con.close();
		}
	}
}
