package com.qa.hobbyproject.ENTITES;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comments")
public class Comments {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", insertable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Date createdDate;

	private String review;
	private String name;
	
	
//	@ManyToOne(targetEntity=User.class)
//	@JsonBackReference
//	@JoinColumn(referencedColumnName = "user_id")
//	private User user;
	public Comments() {
		
	}

//	public Comments(int commentID, Date createdDate, String review, String name) {
//		super();
//		this.commentID = commentID;
//		this.createdDate = createdDate;
//		this.review = review;
//		this.name = name;
//	}
//
//	
//
//	public Comments(Date createdDate, String review, String name) {
//		super();
//		this.createdDate = createdDate;
//		this.review = review;
//		this.name = name;
//	}
//	
//
//	public Comments(String review, String name) {
//		super();
//		this.review = review;
//		this.name = name;
//	}

	//GETTERS & SETTERS
	public int getCommentID() {
		return commentID;
	}

	
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	

}
