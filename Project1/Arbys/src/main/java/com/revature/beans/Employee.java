package com.revature.beans;

public class Employee {
	
	
	
	private int id; 
	private String lastname; 
	private String firstname; 
	private String position; 
	private double salary; 
	private double hours; 
	
	public Employee(int id, String lastname, String firstname, String position, double salary, double hours) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.position = position;
		this.salary = salary;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}	

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", position=" + position
				+ ", salary=" + salary + ", hours=" + hours + "]";
	}

	
	
	



}