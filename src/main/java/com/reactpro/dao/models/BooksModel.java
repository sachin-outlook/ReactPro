package com.reactpro.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class BooksModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title", nullable=false)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;
	
	
	public BooksModel(){
		
	}
	
	

	public BooksModel(String title, String description, boolean published) {
		super();
		this.title = title;
		this.description = description;
		this.published = published;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	
}
