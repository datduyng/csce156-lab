package unl.cse.company;


public class PayrollDemo {

	public static void main(String[] args) {
	
		//TODO - Create two different employees of each type , update their details 
		// and print their names and salaries(change as appropriate to your design)
		Employee employee1 = new TemporaryEmployee("John","Smith",12,12); 
		Employee employee2 = new PermanentEmployee("Richard","Feymann",3.7,23);
		Employee employee3 = new PermanentEmployee("Dat","Nguyen ",12,0);
		Employee employee4 = new TemporaryEmployee("tanky","newMan",2.3,15);
 

		printSalary(employee1);
		printSalary(employee2);
		printSalary(employee3);
		printSalary(employee4);
				
	}

	public static void printSalary(Employee e) {
		System.out.println("Salary of " + e.getName() + " is: "
				+ e.computeSalary());
	}

}