package edu.unl.cse.model;

import java.util.ArrayList;
import java.util.List;

public class Band {

	private Integer bandId;
	private String name;
	private List<Member> members = new ArrayList<Member>();
	
	public Band()
	{
		
	}
	
	public Band(String name, List<Member> members)
	{
		this.name = name;
		if (this.members != null)
		{
			this.members = members;
		}	
	}
	
	public Integer getBandId() {
		return bandId;
	}
	public void setBandId(Integer bandId) {
		this.bandId = bandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
