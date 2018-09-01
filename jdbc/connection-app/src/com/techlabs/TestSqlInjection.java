package com.techlabs;

import java.sql.*;

public class TestSqlInjection {
	private Connection conn;

	public TestSqlInjection(Connection conn) {
		this.conn = conn;
	}

	public void getStudentById(String rollno) {
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select * from student where rollno="+ rollno);
			while (rs.next()) {
				System.out.print(rs.getString("rollno") + ",");
				System.out.print(rs.getString("fname") + ",");
				System.out.print(rs.getString("lname") + ",");
				System.out.print(rs.getString("cgpi") + ",");
				System.out.print(rs.getString("gender") + ",");
				System.out.print(rs.getString("college_id") + ",");
				System.out.println("\n");

			}
		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

}
