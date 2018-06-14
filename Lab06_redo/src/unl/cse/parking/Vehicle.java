package unl.cse.parking;

public abstract class Vehicle {

	private String license;	
	
	// The class constructor
	public Vehicle(String license) {
		this.license = license;
	}
	
	//copy constructor 
	public Vehicle(Vehicle copy) {
		this.license = copy.license;
	}
	
	/**
	 * The getter method granting public access to reading the
	 * license plate number. Notice license does not have a
	 * setter since it cannot be modified.
	 */
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	public abstract double computeTotalFee(int garageDay);
	
}
