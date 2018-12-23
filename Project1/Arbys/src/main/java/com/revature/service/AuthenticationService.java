package com.revature.service;

import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;

public class AuthenticationService {

	public AuthenticationService() {
	}

	public Employee isValidUser(Login login) {
		Employee e = null;
		System.out.println("Login" + login);
		String username = login.getUsername();
		System.out.println("Username: " + username);
		String password = login.getPassword();
		System.out.println("Password: " + password);

		EmployeeDAO emp = new EmployeeDaoImpl();
		LoginDAO log = new LoginDAOImpl();

		if (username != null && password != null) {
			System.out.println("Username and Password Recognized");
			if (username.equals("kjaeger123") && password.equals("password")) {
				int empl;
				try {
					empl = log.login(username, password);
					System.out.println("Employee Login + Password: " + empl);
					System.out.println("this is the username inside Authentication: " + username);
					if (empl != 0) {
						e = emp.getEmployeeById(empl);
					} else {
						System.out.println("User does not exist");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (username.equals("farley123") && password.equals("password")) {
				int empl;
				try {
					empl = log.login(username, password);
					System.out.println("Employee Login + Password: " + empl);
					System.out.println("this is the username inside Authentication: " + username);
					if (empl != 0) {
						e = emp.getEmployeeById(empl);
					} else {
						System.out.println("User does not exist");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		return e;
	}

}