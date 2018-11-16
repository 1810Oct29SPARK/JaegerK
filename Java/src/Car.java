//first POJO!

public class Car extends Vehicle {

	//constructor with no field (a "no-args" constructor)
	public Car() {
		System.out.println("called noargs constructor");
	}

	//constructor with all the fields
	public Car(int yearManufactured, String model, String make){
		//"this " refers to the Car object being created, NOT the argument
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
	}

	//private instance variables, accessible only within the class
	private int yearManufactured;
	private String model;
	private String make;

	//getters and setters (accessors and mutators)
	public int getYearManufactured() {
		return this.yearManufactured;
	}

	public String getModel() {
		return this.model;
	}
	public String getMake() {
		return this.make;
	}
	public void setYearManufactured(int year) {
		this.yearManufactured = year;
	}
	//this causes an instance scope
	public void setModel(String model) {
		this.model = model;
	}
	public void setMake(String make) {
		this.make = make;
	}

	//override inherited move() method
	@Override		//doesn't do anything, but checks to see if override worked
	public void move() {
		System.out.println("Car is moving");
	}
}
