package org.cinco.payroll;

public class StaffEmployee extends HourlyEmployee{
	
	private final static String type = "Staff";
	private final static double taxRate = 0.15;
	
	public StaffEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffEmployee(String id, String firstName, String lastName, String title,
			double hourlyPayRate, double hoursWorked) {
		super(id, firstName, lastName, title, hourlyPayRate, hoursWorked,type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTaxes() {
		return this.getGrossPay() * StaffEmployee.taxRate;
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
