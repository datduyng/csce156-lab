package org.cinco.payroll;

public class SalariedEmployee extends Employee{
	private double annualSalary;
	private final static String type = "Salary";
	private final static double taxRate = 0.2;
	private final static double taxAllowance = 100.00;
	
	public SalariedEmployee() {
		//default
	}
	public SalariedEmployee(String id, String firstName, String lastName,
			String title,double annualSalary) {
		super( id,  firstName,  lastName,  title, type);
		this.setAnnualSalary(annualSalary);
		
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	@Override
	public double getTaxes() {
		return this.getGrossPay() * SalariedEmployee.taxRate;
	}
	@Override
	public double getGrossPay() {
		return this.annualSalary/52.0;
	}
	@Override
	public double getNetPay() {
		return this.getGrossPay() - this.getTaxes() + SalariedEmployee.taxAllowance;
	}
	
	
}
