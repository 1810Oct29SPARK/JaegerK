package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	void addEmployee(int EmployeeId, String EmployeeLastName, String EmployeeFirstName, String EmployeePosition,
			double EmployeeSalary, double EmployeeHours);

	void deleteEmployee(int EmployeeId);

	void updateEmployee(String ColumnName, String NewField, int EmployeeId);
	
	List <Employee> listEmployees(String name);
	
	List <Employee> listAll();

}
