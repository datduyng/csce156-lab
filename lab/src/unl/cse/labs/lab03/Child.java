package unl.cse.labs.lab03;

public class Child {

	private String name;
	private Integer age;
	
	public Child(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.age + ")";
	}
}
