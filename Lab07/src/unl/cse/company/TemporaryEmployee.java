package unl.cse.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TemporaryEmployee extends Employee{
	 private double perHourRate;
	 private double weeklyHrs;
	
	 
 
	public TemporaryEmployee(String firstName, String lastName, double perHourRate, double weeklyHrs ) {
		super(firstName, lastName);
		this.setPerHourRate(perHourRate);
		this.setWeeklyHrs(weeklyHrs);
	}
		
	public TemporaryEmployee(String firstName, String lastName,ArrayList<Product> productSolds, double perHourRate, double weeklyHrs ) {
		super(firstName, lastName, productSolds);
		this.setPerHourRate(perHourRate);
		this.setWeeklyHrs(weeklyHrs);
	}
	
	
	public double getPerHourRate() {
		return this.perHourRate;
	}

	public void setPerHourRate(double perHourRate) {
		this.perHourRate = perHourRate;
	}

	public double getWeeklyHrs() {
		return weeklyHrs;
	}

	public void setWeeklyHrs(double weeklyHrs) {
		this.weeklyHrs = weeklyHrs;
	}



	@Override
	public void serializeToJSON(Serializable jsonSerializable, File file) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		//use to print neat tree model JSON result 
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonInString = String.format("{\n \"%s\": %s}",jsonSerializable.toString(),gson.toJson(jsonSerializable) );
		
		System.out.println(file.getPath());
		// parse JSON output to aa file 
		FileWriter output = null;
		try {
			output = new FileWriter(file.getPath());
			output.write(jsonInString);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// close output file
		try {
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void computeProductivity() {
		// TODO Auto-generated method stub
		double employeeProductivity = this.computeSalary() / 168.0; //number of hour per weekt

		
		System.out.println("employeeProductivity (over last week): " + employeeProductivity);
		//
	}
	@Override
	public double computeSalary() {
		return this.getPerHourRate() * this.getWeeklyHrs();
	}

	public String toString() {
		return "TemporaryEmployee";
	}
}

