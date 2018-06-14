package unl.cse.parking;

public class CompactCar extends Vehicle  {
	public CompactCar(String license) {
		super(license);
		// TODO Auto-generated constructor stub
	}
	
	//copy constructor 
	public CompactCar(Vehicle copy) {
		super(copy.getLicense());
	}
	public static final double oneWeekFee = 6.00;
	public static final double severalWeekFee = 4.50;
	
	public static double getOneweekfee() {
		return oneWeekFee;
	}
	public static double getSeveralweekfee() {
		return severalWeekFee;
	}
	
	public double computeTotalFee(int garageDay) { 
		if(garageDay <= 7) {// if the car has been stay less a week
			return (double)garageDay * CompactCar.oneWeekFee;
		}else {
			return (double)garageDay * CompactCar.severalWeekFee;
		}
	}

	@Override 
	public String toString() {
		return "CompactCar";
	}
	
}
