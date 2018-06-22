package unl.cse.recursion;

import java.math.BigInteger;
import java.util.HashMap;


public class PellNumbers {

	public static HashMap<Integer,BigInteger> memo = new HashMap<Integer,BigInteger>();

	private static final BigInteger TWO = new BigInteger("2");

	public static BigInteger PellNumber(Integer n) {
		if(n == 0) {
			return BigInteger.ZERO;
		} else if(n == 1) {
			return BigInteger.ONE;
		} else {
			BigInteger a = PellNumber(n-1);
			BigInteger b = PellNumber(n-2);
			return a.multiply(TWO).add(b);
		}
	}
	
	public static BigInteger PellNumberWMemo(Integer n) {
		if(n == 0) {
			return BigInteger.ZERO;
		} else if(n == 1) {
			return BigInteger.ONE;
		} else {
			
			// find to see has it exist on the map.
			// if the result is already found previously and exist in the map
			if(memo.containsKey(n)) {
				// return it.
				return memo.get(n);
			}else {
				// if not in the map then calculate it then 
				// add it to the map. then return it 
				BigInteger a = PellNumberWMemo(n-1);
				BigInteger b = PellNumberWMemo(n-2);
				BigInteger result = a.multiply(TWO).add(b);
				
				// add it 
				memo.put(n, result);
				return result;
			}
			
		}
	}
	
	public static void main(String args[]) {
		
		int n = 20;
		
		//calculate time
		long start, end;
		start = System.nanoTime();
		BigInteger p_n = PellNumberWMemo(n);
		end = System.nanoTime();
		
		double ms = (end-start) / 1000000.0;
		
		System.out.println("p("+n+") = "+p_n.toString());
		System.out.println("execution time = "+ms+"ms");
		
		
		
	}
}
