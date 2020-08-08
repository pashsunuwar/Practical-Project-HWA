package com.qa.hobbyproject.SERVICE;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.ENTITES.Comments;
import com.qa.hobbyproject.REPOSITORY.CommentsRepo;

@Service
public class CommentService {
	
	@Autowired
	CommentsRepo commentsrepo;
	
	//create
	public Comments postComment(Comments comment) {
		return commentsrepo.save(comment);
	}
	
	//read
	public List<Comments> showallComments() {
		return commentsrepo.findAll();
	}
	
	//update
	public String editComment(Comments comment) {
		String message = "";
		
		return message;
		
	}
	
	//delete
	public String deleteComment(int id) {
		String msg = "";
		commentsrepo.deleteById(id);
		msg = " Successfully deleted the post with comment ID: " + id +". ";
		return msg;
	}
	
	

}
