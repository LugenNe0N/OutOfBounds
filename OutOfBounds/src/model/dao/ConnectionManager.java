package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private final static String URL = "jdbc:mysql://localhost:3306/task_db?useSSL=false";
	private final static String USER = "taskU";
	private final static String PASSWORD = "taskP";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
