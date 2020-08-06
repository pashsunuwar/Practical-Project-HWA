package com.qa.hobbyproject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.ENTITES.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
//	public List<User> findByName(String name);
//	public List<User> findByUsername(String username);
//	public List<User> findByEmail(String email);
	
}
