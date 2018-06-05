package unl.cse.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Employee  implements Serializable,CompanyPortfolio{
	
	int id;
	private String firstName;
	private String lastName;
	private String title;	
	private ArrayList<Product> productSolds = new ArrayList<Product>();
	
	/* TODO - Do you need any more fields here ? (e.g netPay, grossPay etc)
	 *  	    
	 */

	/* TODO Add other methods (e.g getName(), computeSalary()) 
	 * 		Which of them do you think should be abstract ?
	 */
	
	/* TODO What other subclasses do you need ? (e.g Hourly, Temporary etc)
	 * 		What methods can be implemented there ?  (e.g hourlyPay/overtimePay?, getpay? getName? etc) 
	 * 		Which of them can be abstract here ?*/

	public Employee(String firstName, String lastName,ArrayList<Product> productSolds ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.productSolds = productSolds;
	}
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ArrayList<Product> getProductSolds(){
		return this.productSolds;
	}
	public void setProductSolds(ArrayList<Product> productSolds){
		this.productSolds = productSolds;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return this.getFirstName() +", "+ this.getLastName();
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*abstract method */
	public abstract double computeSalary();
	
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

}
