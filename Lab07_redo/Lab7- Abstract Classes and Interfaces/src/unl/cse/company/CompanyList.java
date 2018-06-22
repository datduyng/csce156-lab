package unl.cse.company;

import java.util.ArrayList;

public class CompanyList<T> {

	public CompanyList() {
		tarray = new ArrayList<T>();
	}

	private ArrayList<T> tarray;

	public void addToArray(T t) {
		tarray.add(t);
	}

	//TODO: Add a toString method for employees for displaying (optional) 
	public void print() {
		System.out.println(tarray.toString());
	}

}
