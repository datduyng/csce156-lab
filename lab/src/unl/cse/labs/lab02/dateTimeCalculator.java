package unl.cse.labs.lab02;

/** 
 * @author dat nguyen 
 * Date: 5/15/18 
 * this program will calcutlate the number of years, months, date 
 * between 2 given date.
 * this program need improvement. need better data structure.
 */
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;

public class dateTimeCalculator {
	public static void main(String args[]){
		
		if(args.length != 6){
			System.err.println("USAGE: day1 month1 year1 day2 month2 year2");
			System.exit(1);
		}
		// each date will get store in an array 
		// format [year, month, day]
		int date1[] = new int[3];
		int date2[] = new int[3];
		
		date1[0] = Integer.parseInt(args[0]);
		date1[1] = Integer.parseInt(args[1]);
		date1[2] = Integer.parseInt(args[2]);
		
		date2[0] = Integer.parseInt(args[3]);
		date2[1] = Integer.parseInt(args[4]);
		date2[2] = Integer.parseInt(args[5]);
		
		DateTime dateTime1 = new DateTime(date1[2],date1[1],date1[0],0,0);//year, month, date, 0, 0
		DateTime dateTime2 = new DateTime(date2[2],date2[1],date2[0],0,0);
		
		Period timeFrame = new Period(dateTime1,dateTime2);
		
		int year = timeFrame.getYears();
		int month = timeFrame.getMonths();
		int day = timeFrame.getDays();
		
		System.out.printf("time frame between (%d/%d/%d)-(%d,%d,%d) is %d y, %d m, %d d",
				date1[0],date1[1],date1[2],date2[0],date2[1],date2[2],year, month, day);
		
	}// end main
}// end class
