package testexam.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {
	private static String url = "jdbc:postgresql://localhost:5432/school";
 	private static String user = "postgres";
 	private static String password = "123";
 	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int add(String user, String password) {
		int res = 0;
		String sql = "INSERT into login VALUES(?,?)";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, user);
			pstm.setString(2, password);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int fetch(String username, String password) {
		String sql = "SELECT * FROM login WHERE username = ? and password=?";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
