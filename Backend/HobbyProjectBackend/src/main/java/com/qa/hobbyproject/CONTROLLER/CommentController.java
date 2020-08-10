package com.qa.hobbyproject.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.ENTITES.Comments;
import com.qa.hobbyproject.SERVICE.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentservice;
	
	@PostMapping("/new")
	public Comments newComment(@RequestBody Comments comment) {
		return commentservice.postComment(comment);
	}
	
	@GetMapping("/showall")
	public List<Comments> showall() {
		return commentservice.showallComments();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteComment(@PathVariable int id) {
		String msg = "";
		commentservice.deleteComment(id);
		msg = " Successfully deleted the post with comment ID: " + id +". ";
		return msg;
	}
	
}
