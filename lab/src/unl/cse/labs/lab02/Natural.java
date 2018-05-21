package unl.cse.labs.lab02;

public class Natural {

	public static void main(String args[]) {
		if(args.length != 1) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}
		
		Integer n = null;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}
		
		String zeroToTen[] = new String[11];
		zeroToTen[0] = "zero";
		zeroToTen[1] = "one";
		zeroToTen[2] = "two";
		zeroToTen[3] = "three";
		zeroToTen[4] = "four";
		zeroToTen[5] = "five";
		zeroToTen[6] = "six";
		zeroToTen[7] = "seven";
		zeroToTen[8] = "eight";
		zeroToTen[9] = "nine";
		zeroToTen[10] = "ten";

		int result = 0;
		int i =0;//iteration
		//TODO: write a for-loop to compute the sum of 1..n
		for(i = 0;i <= n; i++){
			result += i;
		}
		System.out.println("sum of 1-" + n +"(for-loop) is "+ result);
		
		//TODO: write a while-loop to compute the sum of 1..n
		i = 0;
		result =0;
		while(i <= n){
			result += i;
			i ++;
		}
		
		System.out.println("sum of 1-" + n +"(while-loop) is "+ result);
		
		
		//TODO: write an enhanced for-loop to iterate over the zeroToTen array 
		i = 0;
		for(i =0 ;i < zeroToTen.length; i++){
			System.out.printf("%s ",zeroToTen[i]);
		}

	}// end main 
}// end class
