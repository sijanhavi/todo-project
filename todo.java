package com.todo.TODO;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class todo {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private String username;
	private String description;
	private Date targetdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetdate() {
		return targetdate;
	}
	
	public todo(int id, String username, String description, Date targetdate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
	}
	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
	}
	public todo() {
		super();
	}
	
	
	
	
}
