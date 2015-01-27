package com.itu.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

public class MySQLConnectionTest extends TestCase {

	public void testConnect() {
		String dbUrl = "jdbc:mysql://localhost:3306/itu";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * from student";
		String username = "root";
		String password = "gqq";
		try {

			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String sName = resultSet.getString("name");
				System.out.println("student name : " + sName);
			}
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SQLException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
