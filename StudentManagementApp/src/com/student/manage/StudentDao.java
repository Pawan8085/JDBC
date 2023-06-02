package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public static boolean insertStudentToDB(Student student) {

		boolean flag = false;

		try {

			// get the connection

			Connection con = ConnectionProvider.createConnection();

			String q = "insert into students (sname, sphone, scity) values(?,?,?)";

			// PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);

			// set the value of parameter
			pstm.setString(1, student.getStudentName());
			pstm.setString(2, student.getStudentPhone());
			pstm.setString(3, student.getStudentCity());

			// execute
			pstm.executeUpdate();

			flag = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}

	public static boolean delteStudent(int id) {
		boolean flag = false;

		try {

			// get the connection

			Connection con = ConnectionProvider.createConnection();

			String q = "delete from students where sid=? ";

			// PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);

			// set the value of parameter
			pstm.setInt(1, id);

			// execute
			pstm.executeUpdate();

			flag = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudents() {

		try {

			// get the connection

			Connection con = ConnectionProvider.createConnection();

			String q = "select * from students";

			// Statement
			Statement stm = con.createStatement();

			ResultSet set = stm.executeQuery(q);

			while (set.next()) {
				System.out.println("Student Id : " + set.getInt(1));
				System.out.println("Student Name : " + set.getString(2));
				System.out.println("Student Phone : " + set.getString(3));
				System.out.println("Student City : " + set.getString(4));
				System.out.println("__________________________________");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static boolean updateStudent(String name, int id) {
		
		boolean flag = false;

		try {

			// get the connection

			Connection con = ConnectionProvider.createConnection();

			String q = "UPDATE students SET sname = ? WHERE sid = ?";

			// PreparedStatement
			PreparedStatement pstm = con.prepareStatement(q);

			// set the value of parameter
			pstm.setString(1, name);
			pstm.setInt(2, id);
			

			// execute
			pstm.executeUpdate();

			flag = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return flag;
	}
}
