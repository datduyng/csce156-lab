package org.cinco.payroll;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

//import unl.cse.library.Book;

public class PayrollReport {
	public static List<Employee> result = new ArrayList<Employee>();
	public static List<Employee> parseDataFile() {
		//List<Employee> result = new ArrayList<Employee>();
		try {
			File f = new File("data/employee.dat");
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				if(!line.trim().isEmpty()) {
					Employee e = null;
					String tokens[] = line.split(";");
					String id = tokens[1];
					String nameTokens[] = tokens[2].split(",");
					String lastName = nameTokens[0];
					String firstName = nameTokens[1];
					String title = tokens[3];
					double annualSalary = 0.0, hourlyPayRate = 0.0, hoursWorked = 0.0;
					if(tokens.length == 6) {
						hourlyPayRate = Double.parseDouble(tokens[4]);
						hoursWorked = Double.parseDouble(tokens[5]);
					} else if(tokens.length == 5) {
						annualSalary = Double.parseDouble(tokens[4]);
					}
					
					if(tokens[0].equals("E")) {
						e = new SalariedEmployee( id,  firstName,lastName,title, annualSalary); //TODO: modify this
						System.out.println( ((SalariedEmployee)e).getAnnualSalary());
					} else if(tokens[0].equals("S")) {
						e = new StaffEmployee(id, firstName, lastName, title, hourlyPayRate, hoursWorked); //TODO: modify this
					} else if(tokens[0].equals("T")) {
						e = new TemporaryEmployee(id, firstName, lastName, title, hourlyPayRate, hoursWorked); //TODO: modify this
					}
					
					result.add(e);
					
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String args[]) {

		//get the employees from the data file
		List<Employee> payroll = parseDataFile();

		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%-8s %-20s %-10s %-30s %9s %9s %9s\n", 
				"ID", "Name", "Type", "Title", "Gross", "Taxes", "Net"));

		//for each employee
		for(Employee e : payroll) {
			//format their information
			sb.append(String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
					e.getId(), e.getName(), e.getType(), 
					e.getTitle(), e.getGrossPay(), e.getTaxes(),
					e.getNetPay())); //TODO: replace these
		}
		
		System.out.println(sb);
		
		// sort book.
    	Collections.sort(payroll, new Comparator<Employee>() {
    	    @Override
    	    public int compare(Employee o1, Employee o2) {
    	    	if(o1.getNetPay() > o2.getNetPay()) {
    	    		return -1;
    	    	}else if(o1.getNetPay() == o2.getNetPay()) {
    	    		return 0;
    	    	}else {
    	    		return 1;
    	    	}
    	        //return o1.getTitle().compareTo(o2.getTitle());
    	    }
    	});
    	System.out.println("Sorted list===============================");
    	
    	StringBuilder sb2 = new StringBuilder();
    	TreeSet<Employee> ts= new TreeSet();
		//for each employee
		for(Employee e : payroll) {
			//format their information
			sb2.append (String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
					e.getId(), e.getName(), e.getType(), 
					e.getTitle(), e.getGrossPay(), e.getTaxes(),
					e.getNetPay())); //TODO: replace these
			//ts.add(e);
		}
		
		System.out.println(sb2);
		
		System.out.println("Tree Set list===============================");
		System.out.println(ts);
		
	}// end main
	
	
}
