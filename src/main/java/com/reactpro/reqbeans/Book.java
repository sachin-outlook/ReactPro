package com.reactpro.reqbeans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Book {
	
	private String name;
	
	
	private String pname;
	
	@NotNull
	private String author;
	
	
	public Book(){
		
	}
	
	public Book(String name, String pname, String author) {
		super();
		this.name = name;
		this.pname = pname;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
