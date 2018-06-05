package unl.cse.company;


public class PayrollDemo {

	public static void main(String[] args) {
	
		//TODO - Create two different employees of each type , update their details 
		// and print their names and salaries(change as appropriate to your design)
		Employee employee1 = new Temporary("John","Smith"); 
		Employee employee2 = new Permanent("Richard","Feymann");
 

		printSalary(employee1);
		printSalary(employee2);
				
	}

	public static void printSalary(Employee e) {
		System.out.println("Salary of " + e.getName() + " is: "
				+ e.getPay());
	}

}