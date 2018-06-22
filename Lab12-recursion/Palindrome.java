package unl.cse.recursion;

import java.util.Scanner;

public class Palindrome {

	public boolean isPalindrome(String s) {
		int end = s.length() - 1;
		int start = 0;
		if(s.length() == 0) {
			return true;
		} else if(s.length() == 1) {
			return true;
		}
		
		if(s.charAt(start) == s.charAt(end)){
			s = s.substring(start+1, end);
			System.out.println(s);
			isPalindrome(s);
		}else{
			return false;
		}
		
		return true;

	}
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		Palindrome p = new Palindrome();
		System.out.println("Enter a word: ");
		String str = s.next();
		System.out.println(str+" ==is a palindrome? "+p.isPalindrome(str));
	}
}
