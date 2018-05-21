package unl.cse.labs.lab01;

import java.util.Scanner;

public class StatisticsDemo {

	public static void main(String args[]) {
		
		/* TODO: Complete this part*/
		/**
		Scanner s = new Scanner(System.in);

		System.out.println("Please input the number of integers being entered (>=2): ");
		int n = s.nextInt();
		if(n < 2) {
			System.out.println("Error: please enter at least 2");
			System.exit(1);
		}
		int array[] = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter another integer: ");
			array[i] = s.nextInt();
		}
        */
		
        int n = args.length;
        int array[] = new int[n];
        
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(args[i]);
		}
        
		int min = Statistics.getMin(array);
		int max = Statistics.getMax(array);
		int sum = Statistics.getSum(array);
		double ave = Statistics.getAverage(array);
		
		System.out.println("The sum is " + sum);
		System.out.println("The average is " + ave);
		System.out.println("The highest is " + max);
		System.out.println("The lowest is " + min);

	}
}
