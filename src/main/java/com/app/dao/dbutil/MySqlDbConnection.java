package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnection {

	private static Connection connection;

	private MySqlDbConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/project1";
		String username = "root";
		String password = "Auc@963";
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}
}
