package unl.cse.parking;

public class MotorBike extends Vehicle  {
	public MotorBike(String license) {
		super(license);
		// TODO Auto-generated constructor stub
	}
	
	//copy constructor 
	public MotorBike(Vehicle copy) {
		super(copy.getLicense());
	}
	
	
	public static final double oneWeekFee = 4.00;
	public static final double severalWeekFee = 3.00;
	
	public static double getOneweekfee() {
		return oneWeekFee;
	}
	public static double getSeveralweekfee() {
		return severalWeekFee;
	}
	
	public double computeTotalFee(int garageDay) { 
		if(garageDay <= 7) {// if the car has been stay less a week
			return (double)garageDay * MotorBike.oneWeekFee;
		}else {
			return (double)garageDay * MotorBike.severalWeekFee;
		}
	}
	

	@Override 
	public String toString() {
		return "Motorbike";
	}
	
}
