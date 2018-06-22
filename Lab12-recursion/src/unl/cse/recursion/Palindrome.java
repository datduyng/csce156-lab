package unl.cse.recursion;

import java.util.Scanner;

public class Palindrome {

	public boolean isPalindrome(String s) {
		//TODO: you need to implement this method
		return false;
	}
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		Palindrome p = new Palindrome();
		System.out.println("Enter a word: ");
		String str = s.next();
		System.out.println(str+" is a palindrome? "+p.isPalindrome(str));
	}
}
