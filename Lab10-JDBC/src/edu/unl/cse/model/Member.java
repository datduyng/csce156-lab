package edu.unl.cse.model;

public class Member {
	private String firstName;
	private String lastName;
	private String country;
	
	public Member(String first, String last, String country)
	{
		this.firstName = first;
		this.lastName = last;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
