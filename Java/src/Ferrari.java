public class Ferrari extends Vehicle {
	private int yearManufactured;
	public void setYearManufactured(int year) {
		this.yearManufactured = year;
	}
	private String park;
	public String parkCar() {
		return this.park;
	}

	@Override
	public void move() {
		System.out.println("Ferrari is moving");
	}
}
