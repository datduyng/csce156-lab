package unl.cse.parking;

public abstract class Vehicle {

	private final String license;	
	private int day;
	

	// The class constructor
	public Vehicle(String license) {
		this.license = license;
		this.day = 1;
	}
	
	// copy constructor 
	public Vehicle(Vehicle automobile) {
		this.license = automobile.license;
	}
	
	/**
	 * The getter method granting public access to reading the
	 * license plate number. Notice license does not have a
	 * setter since it cannot be modified.
	 */
	public String getLicense() {
		return license;
	}
	
	public int getDay() {
		return this.day;
	}

	public void setDay(int numOfDay) {
		this.day+=numOfDay;
	}
	

	//public abstract String toString();
	public abstract double getFee();
	
}
