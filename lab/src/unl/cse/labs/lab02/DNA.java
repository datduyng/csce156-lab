package unl.cse.labs.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DNA {

	public static void main(String args[]) {

		String fileName = "data/H1N1nucleotide.txt";
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String dna = "";

		/* reazd in the subsequence via cmd line*/
		if(args.length != 1){
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}

		while(s.hasNext()) {
			dna += s.next().trim();
		}
		s.close();

		String subsequence = args[0];

		int count = 0; 
		int i = 0, contain = 0;// iteration
		
		//write code to count the number of times subsequence appears in the dna string
		for(i = 0;i < dna.length(); i++){
			contain = dna.indexOf(subsequence,i);
			if(contain != -1){
				i = contain + subsequence.length() - 1;
				count++;
			}else{
				break;
			}
		}
		
		System.out.println(subsequence + " appears " + count + " times");
		
	}
	
}
