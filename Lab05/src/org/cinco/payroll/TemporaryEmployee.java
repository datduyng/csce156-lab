package org.cinco.payroll;

public class TemporaryEmployee extends HourlyEmployee{


	private final static double taxRate = 0.0;
	private final static String type = "Temporary";
	
	public TemporaryEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemporaryEmployee(String id, String firstName, String lastName, String title, double hourlyPayRate,
			double hoursWorked) {
		super(id, firstName, lastName, title, hourlyPayRate, hoursWorked,type);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxes() {
		return this.getGrossPay() * TemporaryEmployee.taxRate;
	}
	@Override
	public double getGrossPay() {
		return this.getHourlyPayRate() * this.getHoursWorked();
	}
	@Override
	public double getNetPay() {
		return this.getGrossPay() - this.getTaxes();
	}
	
}
