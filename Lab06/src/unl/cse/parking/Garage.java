package unl.cse.parking;

public class Garage {

	private final Vehicle stalls[];
	private int calendarDay;
	private int calendarWeek;
	
	public Garage(int capacity) {
		stalls = new Vehicle[capacity];
		this.calendarDay = 1;
		this.calendarWeek = 1;
	}
	
	public int getCalendarDay() {
		return calendarDay;
	}

	public void setCalendarDay(int calendarDay) {
		this.calendarDay = calendarDay;
	}
	

	/**
	 * "Parks" the vehicle in a stall if one is available.  Returns true if
	 * the vehicle was added successfully; false otherwise.
	 */
	public boolean addVehicle(Vehicle automobile) {
		for(int i =0;i<stalls.length; i++) {
			if(stalls[i] == null) {
				stalls[i] = automobile;
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
		for(int i =0;i<stalls.length; i++) {
			if(stalls[i] != null) {
				if(stalls[i].getLicense().equals(license)) {
					Vehicle vehicleResult = (stalls[i]);
					stalls[i] = null;
					//return null;
				}
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
		this.calendarDay ++;
		for(int i = 0;i< stalls.length;i++) {
			if(stalls[i]!= null) {
				stalls[i].setDay(1);
			}
		}
		

		
	}
	
	public void addDay(int numDays) {
		//this.calendarDay += numDays;
		int i = 0;
		while(i <= numDays) {
			this.addDay();
			i++;
		}
		
	}
	
	
	/**
	 * This function return day of week 
	 * @param days
	 * @return
	 */
	public int getDayOfWeek(int days) {
		return days%7;
	}
	
	public int getWeek() {
		return 0;
	}
	/**
	 * Displays the current "state" of the garage by printing out information about each
	 * stall
	 */
	public void displayReport() {
		System.out.println("Day:"+this.getCalendarDay());
		System.out.println("Week:"+this.calendarWeek);
		System.out.println("Stall License Type          Days   Total Fee");
		for(int i=0; i<this.stalls.length; i++) {
			if(stalls[i] == null) {
				System.out.println(String.format("%3d EMPTY", (i+1)));
			} else {
				//TODO: You will need to modify these arguments to display the report correctly
				System.out.println(String.format("%3d %-10s %-11s %3d    $%5.2f", (i+1), stalls[i].getLicense(), stalls[i].toString(), 
						stalls[i].getDay(), stalls[i].getFee()));
			}
		}
	}
	
}