package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;
import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		//Initiate Connection
		init();
		
		//Try getEmployeeById
		EmployeeDAO ed = new EmployeeDaoImpl();
		System.out.println(ed.getEmployeeById(1));
		
//		Try addEmployee
		ed.addEmployee(20, "JAEGER", "CAITLIN", "SERVER", 2000, 10);
		
		//Try addEmployee
		ed.deleteEmployee(20);
		
		ReimbursementsDAO rd = new ReimbursementsDAOImpl();
		rd.addImage(1);
	}
	
	
	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Completed");
	}


	public Object addEmployee(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object updateEmployee(String string) {
		// TODO Auto-generated method stub
		return null;
	}


//	public static Object getEmployeeById(int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public Object deleteEmployee(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object login(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object signout(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object updatePassword(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object view(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object submit(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object update(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean approve(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	public Object[] getEmployeeById(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}