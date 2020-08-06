package com.qa.hobbyproject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.ENTITES.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Integer> {
	
//	@Query(value="UPDATE comments SET review ")
	
	
	
}
