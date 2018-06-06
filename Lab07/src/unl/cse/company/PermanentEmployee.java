package unl.cse.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PermanentEmployee extends Employee{

	private double weeklySalary; 
	private double overtimeHrs;
	public static final double overtimeRate = 2.0;// change this.
	
	
	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public double getOvertimeHrs() {
		return overtimeHrs;
	}

	public void setOvertimeHrs(double overtimeHrs) {
		this.overtimeHrs = overtimeHrs;
	}

		
	public PermanentEmployee(String firstName, String lastName, double weeklySalary, double overtimeHrs ) {
		super(firstName, lastName);
		this.setWeeklySalary(weeklySalary);
		this.setOvertimeHrs(overtimeHrs);
	}
	
	public PermanentEmployee(String firstName, String lastName,ArrayList<Product> productSolds, double weeklySalary, double overtimeHrs ) {
		super(firstName, lastName, productSolds);
		this.setWeeklySalary(weeklySalary);
		this.setOvertimeHrs(overtimeHrs);
	}

//	@Override
//	public void serializeToJSON(Serializable jsonSerializable, File file) throws IOException {
//		// TODO Auto-generated method stub
//		Gson gson = new Gson();
//		
//		//use to print neat tree model JSON result 
//		gson = new GsonBuilder().setPrettyPrinting().create();
//		
//		String jsonInString = String.format("{\n \"%s\": %s}",jsonSerializable.toString(),gson.toJson(jsonSerializable) );
//		
//
//		// parse JSON output to aa file 
//		FileWriter output = null;
//		try {
//			output = new FileWriter(file.getPath());
//			output.write(jsonInString);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		// close output file
//		try {
//			output.close();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public void computeProductivity() {
//		// TODO Auto-generated method stub
//		double employeeProductivity = this.computeSalary() / 168.0; //number of hour per weekt
////		double performanceProductivity = 0.0;
////		
////		// loop through the list of product count total cost then * total item sold. / number of hrs in week.
////		for(Product nextProductSold : this.getProductSolds()) {
////			performanceProductivity += nextProductSold.getCost() * nextProductSold.getCountItemSold() / 168.0 ; // total number of hrs per week.
////		}
//		
//		System.out.println("employeeProductivity (over last week): " + employeeProductivity);
//		//System.out.println("performanceProductivity (over last week): " + performanceProductivity);
//	}

	@Override
	public double computeSalary() {
		return this.weeklySalary + (this.overtimeHrs * PermanentEmployee.overtimeRate);
	}

//	@Override
//	public void computeProductivity() {
//		// TODO Auto-generated method stub
//		
//	}

}
