package unl.cse.labs.lab02;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;

public class Birthday {

	public static void main(String args[]) {
		
		String name = "Dat";
		
		int month = 3;
		int date  = 9;
		int year  = 1994;

		DateTime bday = new DateTime(year, month, date, 0, 0);
		DateTime today = new DateTime();

		Period age = new Period(bday, today);
		
		int years = age.getYears();
		int months = age.getMonths();
		int days = age.getWeeks() * 7 + age.getDays();

		DateTime next_bday = new DateTime(year + years + 1, month, date, 0, 0);
		Interval days_to_next_bday_i = new Interval(today, next_bday);
		double days_remaining = days_to_next_bday_i.toDurationMillis() / (1000 * 60 * 60 * 24) + 1;

		//TODO: write code to output results here
		System.out.printf("hello %s, today you are %d years, %d months, %d days\n",name, years,months,days);
		if(months == 0 && days == 0){
			System.out.println("Happy birthday!");
		}else{
			System.out.printf("Your friends have %f shopping days until your next birthday”",days_remaining);
		}
	}// end main 
}// end class
