package org.cinco.payroll;

public abstract class  HourlyEmployee extends Employee {

	private double hourlyPayRate;
	private double hoursWorked;
	
	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(String id, String firstName, String lastName, String title
			,double hourlyPayRate, double hoursWorked,String type) {
		super(id, firstName, lastName, title,type);
		this.setHourlyPayRate(hourlyPayRate);
		this.setHoursWorked(hoursWorked);
		
	}

	public double getHourlyPayRate() {
		return hourlyPayRate;
	}

	public void setHourlyPayRate(double hourlyPayRate) {
		this.hourlyPayRate= hourlyPayRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
}
