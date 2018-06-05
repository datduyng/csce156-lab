package unl.cse.company;

public class GenericsDemo {

	public static void main(String args[]) {

		// TODO: Make 2 different types of employees (change as appropriate to your design)
		Employee e1 = new Permanent("",""); 
		Permanent e2 = new Permanent("","");
		//Temporary e3 = new Temporary("E","F");
		
		// TODO: Add them to non-generic company c1 and generic company c2.

		CompanyList c1 = new CompanyList();
		//c1.addToArray(e1);
		c1.print();

		CompanyList<Permanent> c2 = new CompanyList<Permanent>();
		c2.print();

		// TODO: Create a product and try adding to c1 and c2

	}

}
