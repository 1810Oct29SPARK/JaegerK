package com.revature.dao;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	void addEmployee(int EmployeeId, String EmployeeLastName, String EmployeeFirstName, String EmployeePosition,
			double EmployeeSalary, double EmployeeHours);

	void deleteEmployee(int EmployeeId);

	void updateEmployee(int EmployeeId, String EmployeeLastName, String EmployeeFirstName, String EmployeePosition,
			double EmployeeSalary, double EmployeeHours);

}
