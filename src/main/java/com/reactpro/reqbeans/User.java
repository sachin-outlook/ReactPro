package com.reactpro.reqbeans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
	
	
	private long userId;
	
	@NotNull(message="First name Mandatory")
	@NotEmpty(message="First name cannot be empty")
	private String fname;
	@NotNull(message="Last name Mandatory")
	@NotEmpty(message= "Last name cannot be empty")
	private String lname;
	
	@NotNull
	@Min(value=10, message="Age cannot be less than 10")
	private int age;
	
	public User(){
		
	}
	
	
	
	
	public long getUserId() {
		return userId;
	}




	public void setUserId(long userId) {
		this.userId = userId;
	}




	public User(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
