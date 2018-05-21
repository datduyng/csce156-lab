package unl.cse.labs.lab03;
public class ChildCredit {

	public static void main(String args[]) {
		Child tom = new Child("Tommy", 14); // 14 12 21
		Child dick = new Child("Richard", 12);
		Child harry = new Child("Harold", 21);
		
		Child arr[] = new Child[3];
		arr[0] = tom;
		arr[1] = dick;
		arr[2] = harry;
		
		
		// assume that the way the array is sorted 
		//with close to age 18 
		//TODO: write a loop to iterate over the elements in the child array 
		//      and output a table as specified
		int childCreditCount = 0;
		double totalCredit = 0.00;
		System.out.println("Child\t\tAmount");
		
		/*
		for(Child child : arr) {
			double childCreditAmount = 0;
			System.out.print(child.toString());
			if(child.getAge() < 18) {
				childCreditCount++;
				if(childCreditCount == 1) {
					childCreditAmount = 1000.00;
				} else {
					childCreditAmount = 500.00;
				}
			} else {
				childCreditAmount = 0.00;
			}
			
			totalCredit += childCreditAmount;
			System.out.println("\t$" + childCreditAmount);
			
		}
		
		System.out.println("Total Credit:\t$" + totalCredit);
		*/
		String buffer = "";
		
		for(Child child : arr) {
			double childCreditAmount = 0;
			//System.out.print(child.toString());
			if(child.getAge() < 18) {
				childCreditCount++;
				if(childCreditCount == 1) {
					childCreditAmount = 1000.00;
				} else {
					childCreditAmount = 500.00;
				}
			} else {
				childCreditAmount = 0.00;
			}
			
			buffer = String.format("%s \t$ %.2xf",child.toString(),childCreditAmount);
			System.out.println(buffer);
			
			totalCredit += childCreditAmount;
		}
		
		buffer = String.format("Total Credit:\t$ %f",totalCredit);
		System.out.println(buffer);
	}// end main
}// end class