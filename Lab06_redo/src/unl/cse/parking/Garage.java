package unl.cse.parking;

public class Garage {

	private final Vehicle stalls[];
	private final int garageDay[];
	
	public Garage(int capacity) {
		stalls = new Vehicle[capacity];
		garageDay = new int[capacity];
	}
	
	/**
	 * "Parks" the vehicle in a stall if one is available.  Returns true if
	 * the vehicle was added successfully; false otherwise.
	 */
	public boolean addVehicle(Vehicle automobile) {
		//TODO: implement this method
		for(int i =0;i < stalls.length; i++) {
			if(stalls[i] == null){
				stalls[i] = automobile;
				garageDay[i] = 1;// assume that it start on 1st day the vehicle enter
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove the vehicle having the provided
	 * license plate number from the garage. The method returns
	 * the vehicle if it is found otherwise it returns null. 
	 */
	public Vehicle removeVehicle(String license) {
		//TODO: implement this method
		for(int i =0;i < stalls.length; i++) {
			if(stalls[i].getLicense() == license){
				Vehicle copy = null;
				if(stalls[i] instanceof SUV) {
					copy = new SUV(stalls[i]);
				}else if(stalls[i] instanceof CompactCar) {
					copy = new CompactCar(stalls[i]);
				}else if(stalls[i] instanceof MotorBike) {
					copy = new MotorBike(stalls[i]);
				}
				stalls[i] = null;
				garageDay[i] = 0;
				return copy;
			}
		}
		return null;
	}
		
	/**
	 * Returns the maximum capacity of this Garage
	 */
	public int getCapacity() {
		return this.stalls.length;
	}
	
	/**
	 * Returns the number of empty stalls in the garage--the number of open
	 * spots
	 * @return
	 */
	public int getNumFreeSpots() {
		int freeSpots = 0;
		for(int i=0; i<stalls.length; i++) {
			if(stalls[i] == null) {
				freeSpots++;
			}
		}
		return freeSpots;
	}

	/**
	 * Simulates the passing of a day by adding a day in the garage to each vehicle
	 * in the garage.
	 * @return
	 */
	public void addDay() {
		//TODO: implement this
		for(int i =0;i < stalls.length; i++) {
			if(stalls[i] != null) {
				garageDay[i]++;
			}
		}
	}
	
	public void addDay(int numDays) {
		for(int i =0;i < stalls.length; i++) {
			if(stalls[i] != null) {
				garageDay[i]+= numDays;
			}
		}
	}
	
	/**
	 * Displays the current "state" of the garage by printing out information about each
	 * stall
	 */
	public void displayReport() {
		
		System.out.println("Stall License Type Days Total Fee");
		for(int i=0; i<this.stalls.length; i++) {
			if(stalls[i] == null) {
				System.out.println(String.format("%3d EMPTY", (i+1)));
			} else {
				//TODO: You will need to modify these arguments to display the report correctly
				
				System.out.println(String.format("%3d %-10s %-11s %3d $%5.2f", (i+1), stalls[i].getLicense(),
						stalls[i].toString(), garageDay[i], stalls[i].computeTotalFee(garageDay[i])));
			}
		}
	}
}