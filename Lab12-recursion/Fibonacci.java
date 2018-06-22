package unl.cse.recursion;

import java.math.BigInteger;

public class Fibonacci {
	
	private static int count[] = new int[100];
	private static final BigInteger TWO = new BigInteger("2");
	
	public int fibonacci(int n) {

		count[n]++;
		
		if(n == 0) 
			return 0;
		else if(n == 1) 
			return 1;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public BigInteger fibonacciWBig(BigInteger n){
		if(n == BigInteger.ZERO) 
			return BigInteger.ZERO;
		else if(n == BigInteger.ONE) 
			return BigInteger.ONE;
		else
			return (fibonacciWBig(n.subtract(BigInteger.ONE))).add((fibonacciWBig(n.subtract(TWO))));
	}
	
	
	public static void main(String args[]) {
		Fibonacci f = new Fibonacci();
		int result, n = 45;
		BigInteger bigN = new BigInteger("1");
		BigInteger bigResult = new BigInteger("0");

		long start, end;
		start = System.nanoTime();
		//result = f.fibonacci(n);
		bigResult = f.fibonacciWBig(bigN);
		end = System.nanoTime();
		
		double ms = (end-start) / 1000000.0;
		
		//System.out.println("fibonacci("+n+") = "+result);
		System.out.println("fibonacci("+n+") = "+bigResult);
		System.out.println("execution time = "+ms+"ms");
		//System.out.println("count = "+ Fibonacci.count[10]);
		
	}
}
