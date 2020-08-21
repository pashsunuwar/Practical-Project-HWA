package com.qa.hobbyproject.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.ENTITES.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Integer> {
	
	@Query(value="SELECT * FROM comments ORDER BY commentid DESC", nativeQuery = true)
	public List<Comments> descOrder();
	
	@Query(value="UPDATE comments SET review = ?1 where commentid = ?2", nativeQuery = true)
	public Comments updateComms ();
	
}
