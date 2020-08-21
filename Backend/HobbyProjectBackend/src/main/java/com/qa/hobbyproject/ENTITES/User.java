package com.qa.hobbyproject.ENTITES;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int regno;			
	private String name;			
	private String email;
	
//	@OneToMany(mappedBy = "User")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonManagedReference
//	private List<Comments> comments = new ArrayList<>();

	
	
	public User(int regno, String name, String email) {
	super();
	this.regno = regno;
	this.name = name;
	this.email = email;
	}
	
	public User(String name, String email) {
		super();
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 	
	

}
