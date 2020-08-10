package com.qa.hobbyproject.ENTITES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int regno;			
	private String name;		
	private String username;	
	private String email;
	
//	@OneToMany(mappedBy = "users")
//	private Comments comments;
	
	public User() {
	}
	
	public User(int regno, String name, String username, String email) {
	super();
	this.regno = regno;
	this.name = name;
	this.username = username;
	this.email = email;
	}
	
	
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 	
	
	
	

}
