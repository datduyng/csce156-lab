package unl.cse.company;

public abstract class Employee  implements Serializable,CompanyPortfolio{
	
	int id;
	String firstName;
	String lastName;
	String title;
	
	/* TODO - Do you need any more fields here ? (e.g netPay, grossPay etc)
	 *  	    
	 */

	/* TODO Add other methods (e.g getName(), computeSalary()) 
	 * 		Which of them do you think should be abstract ?
	 */
	
	/* TODO What other subclasses do you need ? (e.g Hourly, Temporary etc)
	 * 		What methods can be implemented there ?  (e.g hourlyPay/overtimePay?, getpay? getName? etc) 
	 * 		Which of them can be abstract here ?*/

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
