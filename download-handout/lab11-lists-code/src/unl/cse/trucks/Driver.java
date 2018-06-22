package unl.cse.trucks;

public class Driver {

    public static void main (String[] args){

    	//TODO: Test cases should be made here
    	TruckList tl = new TruckList();
    	Truck t = new Truck.Builder().licensePlate("ABC 123").build();
    	tl.addToEnd(t);
    	tl.print();
	
	}
}
