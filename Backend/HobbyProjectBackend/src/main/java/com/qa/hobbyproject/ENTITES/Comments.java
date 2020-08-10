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

@Entity
@Table(name = "comments")
public class Comments {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", insertable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
//	IT WORKS!!!
	private Date createdDate;
	
//	@ManyToOne
//	@JoinColumn(referencedColumnName = "user_id")
//	private User user;

	private String review;


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


//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}
	

	
	
	
	

}
