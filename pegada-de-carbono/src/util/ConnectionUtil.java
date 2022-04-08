package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection conn;
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3312/poo_pegadacarbono";
			conn = DriverManager.getConnection(url, "root", "");
			conn.setAutoCommit(true);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
		
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
		
}


