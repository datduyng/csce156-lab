package org.cinco.payroll;

public abstract class Employee {

		private String id;
		private String firstName;
		private String lastName; 
		private String title;
		private String type;
		


		public Employee(){
			// default
		}
		
		public Employee(String id, String firstName, String lastName, 
				String title, String type){
			this.setFirstName(firstName);
			this.setId(id);
			this.setLastName(lastName);
			this.setTitle(title);
			this.setType(type);
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
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
		public void setType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
		
		public String getName() {
			return this.getLastName() +", "+ this.getFirstName();
		}
		public abstract double getTaxes();
		public abstract double getGrossPay();
		public abstract double getNetPay();

		
}
