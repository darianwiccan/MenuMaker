package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	/**
	 * Driver class to be used.
	 */
	private final static String driverClass = "org.sqlite.JDBC";

	private DatabaseConnection() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static DatabaseConnection instance = new DatabaseConnection();
	
	public static DatabaseConnection main(String[] args) {
		return instance;
	}

	/**
	 * Connect to MySQL database.
	 * @return 
	 */
	public static Connection run() {
		Connection conn = null;
		try {
			conn = instance.getConnection();
			System.out.println("Connected to database");
			return conn;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Get a new database connection.
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:sqlite:mmdefault.db");
		
		return conn;
	}
}
