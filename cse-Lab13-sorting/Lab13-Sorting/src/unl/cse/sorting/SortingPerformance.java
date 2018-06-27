package unl.cse.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingPerformance {

	private final Integer maxNumLocations;
    private Location locations[];

	public SortingPerformance(Integer maxLocations) {
		this.maxNumLocations = maxLocations;
		this.locations = new Location[maxLocations];
		loadFromFile();
	}

	public Location[] getLocations() {
		return this.locations;
	}

	private void loadFromFile() {

		List<Location> tmp = new ArrayList<Location>();
        try {
            File file = new File("data/geoData.csv");
            Scanner scanner = new Scanner(file);
            //throw away first line
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //create airport objects
                String[] arr = line.split(",");

                Integer z = Integer.parseInt(arr[0]);
                String zip = String.format("%05d", z);
                Double lat = 0d;
                Double lon = 0d;
                String city = arr[3] == null ? "" : arr[3];
                String state = arr[4] == null ? "" : arr[4];
                try {
                	lat = Double.parseDouble(arr[1]);
                	lon = Double.parseDouble(arr[2]);
                } catch(NumberFormatException nfe) {
                	//silence exceptions
                }
                Location location = new Location(zip, lat, lon, city, state);
                tmp.add(location);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        Collections.shuffle(tmp);
        for(int i=0; i<this.maxNumLocations; i++)
        	this.locations[i] = tmp.get(i);
        return;
	}

	public static void printLocationArray(Location list[]) {
		System.out.println(Arrays.toString(list));
	}

	public static void main(String args[]) {

		long start = 0;
		long end = 0;
		double elapsed = 0;

		int n[] = {2000,4000,8000,20000};
		for(int i = 0;i < n.length;i++){
			SortingPerformance sp = new SortingPerformance(n[i]);
//			System.out.println("============================sorted with javaSort====================================================");
//			// java sort algorithm
//			 start = System.nanoTime();
//			Location locations[] = SortingAlgorithms.javaSort(sp.getLocations());
//			 end = System.nanoTime();
//			 elapsed = (end - start);
//			//SortingPerformance.printLocationArray(locations);
//			System.out.println("elapsed time for javasort is: " + elapsed/1000000000.0);

//			//selection sort
//			System.out.println("============================sorted with slection ====================================================");
//			start = System.nanoTime();
//			Location locations1[] = SortingAlgorithms.selectionSort(sp.getLocations());
//			 end = System.nanoTime();
//			 elapsed = (end - start);
//			//SortingPerformance.printLocationArray(locations1);
//				System.out.println("elapsed time for insertion is: " + elapsed/1000000000.0);
	//
//			//insertion sort
	//		System.out.println("============================sorted with insertion ====================================================");
//			start = System.nanoTime();
//			Location locations2[] = SortingAlgorithms.insertionSort(sp.getLocations());
//			 end = System.nanoTime();
//			 elapsed = (end - start);
//			//SortingPerformance.printLocationArray(locations2);
//				System.out.println("elapsed time for insertion is: " + elapsed/1000000000.0);
//			//quick sort
			System.out.println("============================sorted with quicksort ====================================================");
			start = System.nanoTime();
			Location locations3[] = SortingAlgorithms.quickSort(sp.getLocations());
			end = System.nanoTime();
			elapsed = (end - start);
			//SortingPerformance.printLocationArray(locations3);
			System.out.println("elapsed time for quick is: " + elapsed/1000000000.0);
			System.out.println("--------------------------------end------------------------------------------------");

		}


		// unsort
//		System.out.println("============================unsorted ====================================================");
//		SortingPerformance.printLocationArray(sp.getLocations());


	}
}
