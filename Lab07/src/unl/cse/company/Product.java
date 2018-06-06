package unl.cse.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Product implements Serializable,CompanyPortfolio{
	
	private String productCode;
	private int countItemSold;
	private double cost;
	
	
	
	public Product(String productCode, int countItemSold, double cost) {
		super();
		this.setProductCode(productCode); 
		this.setCountItemSold(countItemSold);
		this.setCost(cost);
	}



	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public int getCountItemSold() {
		return countItemSold;
	}



	public void setCountItemSold(int countItemSold) {
		this.countItemSold = countItemSold;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	@Override
	public void serializeToJSON(Serializable jsonSerializable, File file) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		//use to print neat tree model JSON result 
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonInString = String.format("{\n \"%s\": %s}",jsonSerializable.toString(),gson.toJson(jsonSerializable) );
		

		// parse JSON output to aa file 
		FileWriter output = null;
		try {
			output = new FileWriter(file.getName());
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
		double performanceProductivity = 0.0;
		
		// loop through the list of product count total cost then * total item sold. / number of hrs in week.
		
			performanceProductivity = this.getCost() * this.getCountItemSold() / 168.0 ; // total number of hrs per week.
			System.out.println("performanceProductivity (over last week): " + performanceProductivity);
		
	}

}
