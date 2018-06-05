package unl.cse.parking;

public class CompactCar extends Vehicle{
	
	public static final double oneWeekFee = 6.00;
	public static final double overOneWeekFee = 4.50;
	
	public CompactCar(String license) {
		super(license);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public String toString() {
		return "CompactCar";
	}
	
	public double getFee() {
		if(this.getDay() <= 7) {
			return this.getDay() * CompactCar.oneWeekFee;
		}else {
			return this.getDay() * CompactCar.overOneWeekFee;
		}
	}
	
}
