package unl.cse.labs.lab01;

public class Statistics {

	/* TODO: Complete this method to return the sum
	 * of all elements in the array
	 */
	public static int getSum(int array[]) {
	  return 0;
	}
	
	/* This method returns the average
	 * of all elements in the array
	 */
	public static double getAverage(int array[]) {
		if(array == null || array.length < 1)
			return 0;
		int sum = getSum(array);
		return sum / (double) array.length;
	}
	
	/* This method returns the minimum
	 * of all elements in the array
	 */
	public static int getMin(int array[]) {
		if(array == null || array.length == 0)
			return 0;
		int min = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	/* TODO: Complete this method to return the max
	 * of all elements in the array
	 */
	public static int getMax(int array[]) {
	  return 0;
	}
}
