package com.qa.hobbyproject.SERVICE;

import java.util.List;
import java.util.Optional;

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
	
	//recent comments at the top
	public List<Comments> descOrderComments() {
		return commentsrepo.descOrder();
	}
	
	//update
	public Comments editComment(Comments comment, int id) {
		Optional <Comments> opt = commentsrepo.findById(id);
		Comments updatedComms = opt.get();
		updatedComms.setReview(comment.getReview());
		return commentsrepo.save(updatedComms);
	}
	
	//delete
	public String deleteComment(int id) {
		String msg = "";
		commentsrepo.deleteById(id);
		msg = " Successfully deleted the post with comment ID: " + id +". ";
		return msg;
	}
	
	

}
