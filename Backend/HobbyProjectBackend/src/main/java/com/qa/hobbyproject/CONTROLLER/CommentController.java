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
	
	@GetMapping("/viewall")
	public List<Comments> showall() {
		return commentservice.showallComments();
	}
	
	@GetMapping("/showall")
	public List<Comments> descOrderShowall() {
		return commentservice.descOrderComments();
	}
	
	@PostMapping("/edit/{id}")
	public void editComment(@RequestBody Comments comment, @PathVariable int id) {
		commentservice.editComment(comment, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteComment(@PathVariable int id) {
		commentservice.deleteComment(id);	
	}
	
}
