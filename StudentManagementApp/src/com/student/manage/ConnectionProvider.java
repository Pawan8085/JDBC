package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	
	public static Connection createConnection() {
		try {
			
			// load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// create the connection
			String user= "root";
			String password = "eq0144au";
			String url = "jdbc:mysql://localhost:3306/jdbc_student_mangement";
			
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return con;
	}
}
