package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO {

	private static final String filename = "connection.properties";

	@Override
	public Employee getEmployeeById(int id) {
		Employee empl = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			System.out.println("connection success");
			String sql = "SELECT EMPLOYEE_ID, EMPLOYEE_LASTNAME, EMPLOYEE_FIRSTNAME, EMPLOYEE_POSITION, EMPLOYEE_SALARY, EMPLOYEE_HOURS "
					+ "FROM EMPLOYEE " + "WHERE EMPLOYEE_ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int EmployeeId = rs.getInt("EMPLOYEE_ID");
				String EmployeeLastName = rs.getString("EMPLOYEE_LASTNAME");
				String EmployeeFirstName = rs.getString("EMPLOYEE_FIRSTNAME");
				String EmployeePosition = rs.getString("EMPLOYEE_POSITION");
				double EmployeeSalary = rs.getDouble("EMPLOYEE_SALARY");
				double EmployeeHours = rs.getDouble("EMPLOYEE_HOURS");
				empl = new Employee(EmployeeId, EmployeeLastName, EmployeeFirstName, EmployeePosition, EmployeeSalary,
						EmployeeHours);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return empl;
	}

	@Override
	public void addEmployee(int EmployeeId, String EmployeeLastName, String EmployeeFirstName, String EmployeePosition,
			double EmployeeSalary, double EmployeeHours) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			System.out.println("connection success");
			String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, EmployeeId);
			pstmt.setString(2, EmployeeLastName);
			pstmt.setString(3, EmployeeFirstName);
			pstmt.setString(4, EmployeePosition);
			pstmt.setDouble(5, EmployeeSalary);
			pstmt.setDouble(6, EmployeeHours);
			pstmt.executeUpdate();
			System.out.println("Successfully Created Employee");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully added employee");

	}

	@Override
	public void updateEmployee(int EmployeeId, String EmployeeLastName, String EmployeeFirstName,
			String EmployeePosition, double EmployeeSalary, double EmployeeHours) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE EMPLOYEE SET EMPLOYEE_LASTNAME = ?, EMPLOYEE_FIRSTNAME = ?, EMPLOYEE_POSITION = ?, EMPLOYEE_SALARY = ?, EMPLOYEE_HOURS = ?, WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, EmployeeId);
			pstmt.setString(2, EmployeeLastName);
			pstmt.setString(3, EmployeeFirstName);
			pstmt.setString(4, EmployeePosition);
			pstmt.setDouble(5, EmployeeSalary);
			pstmt.setDouble(6, EmployeeHours);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int EmployeeId) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, EmployeeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully Deleted Employee");
	}

}
