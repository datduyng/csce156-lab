package unl.cse.parking;

public class GarageSimulation {
	public static void main(String[] args) {
		
		Garage safePark = new Garage(10);
		
		//create vehicle
		Vehicle ABC123 = new CompactCar("ABC123");
		Vehicle QEDNEB = new SUV("QEDNEB");
		Vehicle XYZ321 = new MotorBike("XYZ321");
		Vehicle QT42 = new MotorBike("QT42");
		Vehicle FOO459 = new CompactCar("FOO459");
		Vehicle BAR560 = new CompactCar("BAR560");
		
		// sunday
		safePark.addVehicle(ABC123);
		safePark.addVehicle(QEDNEB);
		
		//monday 
		safePark.addDay();
		
		//tuesday 
		safePark.addDay();
		safePark.addVehicle(XYZ321);
		
		//wednesday
		safePark.addDay();
		safePark.addVehicle(QT42);
		safePark.addVehicle(FOO459);
		
		//friday 
		safePark.addDay(2);
		safePark.removeVehicle("QT42");
		
		safePark.displayReport();
		safePark.addDay();
		
		/**WEEK 2*/
		//Sunday
		safePark.addDay();
		safePark.removeVehicle("ABC123");
		
		//wednesday
		safePark.addDay(3);
		safePark.addVehicle(BAR560);

		
		
		//FRI
		safePark.addDay(2);
		
		//Sat
		//print report
		safePark.displayReport();
		
	}
}
