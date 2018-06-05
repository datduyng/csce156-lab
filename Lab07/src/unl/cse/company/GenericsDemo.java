package unl.cse.company;

public class GenericsDemo {

	public static void main(String args[]) {

		// TODO: Make 2 different types of employees (change as appropriate to your design)
		
		Employee e1 = new PermanentEmployee("John","Dunkin",12,12); 
		PermanentEmployee e2 = new PermanentEmployee("Mc","Donald",2,12);
		Employee e3 = new TemporaryEmployee("mc","Dunkin",23,12); 
		//Temporary e3 = new Temporary("E","F");
		
		// TODO: Add them to non-generic company c1 and generic company c2.

		CompanyList c1 = new CompanyList();
		c1.addToArray(e1);
		c1.addToArray(e2);
		c1.addToArray(e3);
		c1.print();

		CompanyList<Employee> c2 = new CompanyList<Employee>();
		//CompanyList<PermanentEmployee> c2 = new CompanyList<PermanentEmployee>();
		c2.addToArray(e1);
		c2.addToArray(e2);
		c2.addToArray(e3);
		c2.print();

		// TODO: Create a product and try adding to c1 and c2

	}

}
