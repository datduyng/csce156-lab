package unl.cse.parking;

public class Motorbike extends Vehicle{

	public static final double oneWeekFee = 4.00;
	public static final double overOneWeekFee = 3.00;
	
	public Motorbike(String license) {
		super(license);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public String toString() {
		return "Motorbike";
	}
	
	public double getFee() {
		if(this.getDay() <= 7) {
			return this.getDay() * Motorbike.oneWeekFee;
		}else {
			return this.getDay() * Motorbike.overOneWeekFee;
		}
	}
	
	
}
