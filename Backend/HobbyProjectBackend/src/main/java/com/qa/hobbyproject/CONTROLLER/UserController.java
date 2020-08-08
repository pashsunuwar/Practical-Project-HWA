package com.qa.hobbyproject.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.ENTITES.User;
import com.qa.hobbyproject.SERVICE.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/new")
	public User newUser(@RequestBody User user) {
		return userservice.newUser(user);
	}
	
	@GetMapping("/showall")
	public List<User> showall() {
		return userservice.showallUsers();
	}
	

}
