
package com.qa.hobbyproject.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.ENTITES.User;
import com.qa.hobbyproject.REPOSITORY.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;
	
	public User newUser(User user) {
		return userrepo.save(user);	
	}
	
	public List<User> showallUsers() {
		List<User> records = userrepo.findAll();
		return records;
	}
	
	public String deleteuser(int id) {
		String msg = "";
		userrepo.deleteById(id);
		msg = " Successfully deleted the post with comment ID: " + id +". ";
		return msg;
	}
	
}
