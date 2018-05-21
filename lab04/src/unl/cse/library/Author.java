package unl.cse.library;

public class Author {
	
	private String firstName;   
	private String lastName;
	

	//constructor
	public Author(String firstName, String LastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author() {
		/*constructor*/
	}

	/**
	 * Add mutator method to set this.firstName and this.lastName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		//TODO:input validation for string lastName)
		this.lastName = lastName;
	}

	/*
	 * This method return the author first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/* 
	 * This method return the author last name
	 */
	public String getLastName() {
		return lastName;
	}

	public String getStringAuthor() { 
		String result = this.lastName + "," + this.firstName;
		return result;
	}
	


}// end class

