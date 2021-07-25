package com.reactpro.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id; 
	
	@Column(name = "fname")
	@NotNull
	private String fname;

	@Column(name = "lname")
	private String lname;
	
	@Column(name = "age")
	private int age;

	public Users(){
		
	}
	public Users(String fname, String lname, int age) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
	@Override
	public String toString() {
		return "Users [Id=" + Id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
