package unl.cse.parking;

public class SUV extends Vehicle  {
	public SUV(String license) {
		super(license);
		// TODO Auto-generated constructor stub
	}
	
	//copy constructor 
	public SUV(Vehicle copy) {
		super(copy.getLicense());
	}
	public static final double oneWeekFee = 8.00;
	public static final double severalWeekFee = 6.00;
	
	public static double getOneweekfee() {
		return oneWeekFee;
	}
	public static double getSeveralweekfee() {
		return severalWeekFee;
	}
	
	public double computeTotalFee(int garageDay) { 
		if(garageDay <= 7) {// if the car has been stay less a week
			return (double)garageDay * SUV.oneWeekFee;
		}else {
			return (double)garageDay * SUV.severalWeekFee;
		}
	}
	
	@Override 
	public String toString() {
		return "SUV";
	}
	
}
