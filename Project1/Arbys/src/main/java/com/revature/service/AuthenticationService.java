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
		String username = login.getUsername();
		String password = login.getPassword();

		EmployeeDAO emp = new EmployeeDaoImpl();
		LoginDAO log = new LoginDAOImpl();

		if (username != null && password != null) {
			if (username.equals("kjaeger123") && password.equals("password")) {
				int empl;
				try {
					empl = log.login(username, password);
					if (empl != 0) {
						e = emp.getEmployeeById(empl);
					} else {
						System.out.println("User does not exist");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			if (username.equals("farley123") && password.equals("password")) {
				int empl;
				try {
					empl = log.login(username, password);
					if (empl != 0) {
						e = emp.getEmployeeById(empl);
					} else {
						System.out.println("User does not exist");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			if (username.equals("natale123") && password.equals("password")) {
				int empl;
				try {
					empl = log.login(username, password);
					if (empl != 0) {
						e = emp.getEmployeeById(empl);
					} else {
						System.out.println("User does not exist");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
		return e;
	}

}