package unl.cse.parking;

public class SUV extends Vehicle{

	public static final double oneWeekFee = 8.00;
	public static final double overOneWeekFee = 6.00;
	
	public SUV(String license) {
		super(license);
	} 

	@Override 
	public String toString() {
		return "SUV";
	}
	
	public double getFee() {
		if(this.getDay() <= 7) {
			return this.getDay() * SUV.oneWeekFee;
		}else {
			return this.getDay() * SUV.overOneWeekFee;
		}
	}
}
