package testjdbcjava.batchProcessing;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataProcess {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String password = "123";
	static Connection conn;
	//main method
	public static void main(String[] args) throws SQLException {
		try {
			//1st step: Load & Register Driver Software
			Class.forName("org.postgresql.Driver");
			
			//2nd step: Establishing connection
			conn = DriverManager.getConnection(url, user, password);
			
			//database metadata details
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			System.out.println(databaseMetaData.getDatabaseProductName());
			System.out.println(databaseMetaData.getDatabaseProductVersion());
			System.out.println(databaseMetaData.getDriverName());
			System.out.println(databaseMetaData.getDriverVersion());
			System.out.println(databaseMetaData.getUserName());
			System.out.println(databaseMetaData.getURL());
			
			System.out.println("==================================");
			//query
			String sql = "SELECT * FROM student";
			//create statement
			Statement statement = conn.createStatement();
			
			//executeQuery
			ResultSet resultSet =  statement.executeQuery(sql);
			//table or resultset details
			ResultSetMetaData rsmeta = resultSet.getMetaData();
			System.out.println(rsmeta.getColumnCount());
			System.out.println(rsmeta.getColumnClassName(1));
			System.out.println(rsmeta.getColumnType(1));
			System.out.println(rsmeta.getColumnName(1));
			System.out.println(rsmeta.getColumnTypeName(1));
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
