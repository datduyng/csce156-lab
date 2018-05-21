package unl.cse.labs.lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Baseball {

	public static void main(String args[]) {
		
		String fileName = "data/mlb_nl_2011.txt";
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Team teams[] = new Team[16];
		String buffer = "";
		String name = "";
		int win;
		int loss;
		int i = 0;
		//TODO: read in and process the data file, create teams and add them to the array
		while(s.hasNext()){
			buffer = s.nextLine();
			String []token = buffer.split(" ");
			name = token[0];
			win = Integer.parseInt(token[1]);
			loss = Integer.parseInt(token[2]);
			Team t = new Team(name, win, loss);
			teams[i] = t;
			i++;
		}
		System.out.println("Teams: ");
		for(Team t : teams) {
			System.out.println(t);
		}

		Arrays.sort(teams, new Comparator<Team>() {
			@Override
			public int compare(Team a, Team b) {
				return b.getWinPercentage().compareTo(a.getWinPercentage());
			}
			
		});
		
		System.out.println("\n\nSorted Teams: ");
		for(Team t : teams) {
			System.out.println(t);
		}
		
		//TODO: output the team array to a file as specified
		PrintWriter out = null;
		try{
			out = new PrintWriter("data/mlb_nl_2011_results.txt");
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		
		double winPerc = 0.0;

		
		for(Team team : teams){
			name = team.getName();
			winPerc = team.getWinPercentage() * 100.0;
			out.format("%10s    %.2f \n",name, winPerc);
		}
		out.close();
	}// end main
	
}// end class

