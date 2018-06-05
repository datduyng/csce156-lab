package unl.cse.parking;

public class GarageSimulation {
	public static void main(String[] args) {
		
		Garage safePark = new Garage(10);
		Vehicle QEDNEB = new SUV("QEDNEB");
		Vehicle CSE444 = new SUV("CSE444");
		Vehicle XYZ321 = new Motorbike("XYZ321");
		Vehicle QT42 = new Motorbike("QT42");
		Vehicle ABC123  = new CompactCar("ABC123");
		Vehicle FOO459 = new CompactCar("FOO459");
		Vehicle BAR560 = new CompactCar("BAR560");
		

		

		
		safePark.addVehicle(ABC123);
		safePark.addVehicle(QEDNEB);
		safePark.addDay();
		safePark.addDay();
		safePark.addVehicle(XYZ321);
		safePark.addDay();
		safePark.addVehicle(QT42);
		safePark.addVehicle(FOO459);
		safePark.addDay();
		safePark.addDay();
		safePark.removeVehicle("QT42");
		safePark.addDay();
		safePark.displayReport();
		safePark.addDay();
		safePark.removeVehicle("ABC123");
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();

		
		
		safePark.addVehicle(BAR560);
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.displayReport();
		
		safePark.addDay();
		safePark.removeVehicle("QEDNEB");
		safePark.addDay();
		safePark.addDay();
		safePark.addVehicle(CSE444);
		safePark.addVehicle(QT42);
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.displayReport();
		
		
//		
//		safePark.addDay(2);
//		safePark.removeVehicle("ABC123");
//		safePark.addDay(3);
//		safePark.addVehicle(BAR560);
//		safePark.addDay(8);
		

		
	}
}
