package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	private static final String filename = "connection.properties";
	private Connection con;

	public LoginDAOImpl() {
		try {
			con = ConnectionUtil.getConnection(filename);
			System.out.println("Connection Success");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int login(String username, String password) throws SQLException {
		String sqlStmt = "SELECT EMPLOYEE_ID \r\n" + "FROM LOGIN\r\n"
				+ "WHERE EMPLOYEE_USERNAME = ? AND EMPLOYEE_PASSWORD = ?";

		PreparedStatement pstmt = con.prepareStatement(sqlStmt);

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		System.out.println("SQL Statement Worked");

		if (rs.next()) {
			int empID = rs.getInt("EMPLOYEE_ID");
			return empID;
		} else {
			return 0;
		}
	}

	@Override
	public void signout(String username, String password) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(int id, String password) throws SQLException {

	}

}
