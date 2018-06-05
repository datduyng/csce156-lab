package unl.cse.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PortfolioDemo {

	public static void main(String[] args) {

	//TODO: Create employees and products with details, export to JSON 
	// and compute their productivity (change as appropriate to your design)
	Serializable serializableProduct = new Product("qwe",3,2.5);
	Serializable serializableProduct2 = new Product("123",10,13.0);
	Serializable serializableProduct3 = new Product("asd",20,23.2);
	ArrayList<Product> attach = new ArrayList<Product>();
	attach.add((Product) serializableProduct);
	attach.add((Product) serializableProduct2);
	attach.add((Product) serializableProduct3);
	
	Serializable serializableEmployee = new TemporaryEmployee("Smith","John",attach, 12, 23); 

	


	try {
    	serializableEmployee.serializeToJSON(serializableEmployee, new File("data/Employee.json"));
    	serializableProduct.serializeToJSON(serializableProduct, new File("data/Product.json"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	CompanyPortfolio customerPortfolio = (CompanyPortfolio) serializableEmployee;
	CompanyPortfolio productPortfolio = (CompanyPortfolio) serializableProduct;
	customerPortfolio.computeProductivity();
	productPortfolio.computeProductivity();
	
}
}
