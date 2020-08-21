package com.qa.hobbyproject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbyproject.ENTITES.Comments;
import com.qa.hobbyproject.REPOSITORY.CommentsRepo;
import com.qa.hobbyproject.SERVICE.CommentService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class CommentTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	CommentsRepo commentsrepo;
	
	@Autowired
	CommentService commentservice;
	
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
	
	
//	public User user;
//	public User userwithID;
	
//	public Comments testComment;
//	public Comments testCommentwithID;
//	LocalDateTime createdDate;
//	private List<Comments> comments = new ArrayList<>();
//	
//	
//	@Before
//	public void init() {
//		this.commentsrepo.deleteAll();
//		this.testComment = new Comments("hello", "comment");
//		this.testCommentwithID = this.commentsrepo.save(this.testComment);	
//	}
	
//	@Test
//	void test() throws Exception {
//	MockHttpServletRequestBuilder mockRequest = 
//			MockMvcRequestBuilders.request(HttpMethod.POST, "/comment/new");
//	
//	mockRequest.contentType(MediaType.APPLICATION_JSON)
//	.content(this.mapper.writeValueAsString(testComment))
//		.accept(MediaType.APPLICATION_JSON);
//	
//	ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
//	
//	ResultMatcher matchContent = MockMvcResultMatchers.content()
//			.json(this.mapper.writeValueAsString(testCommentwithID));
//	
//	this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
//	}
	
	@Test
	void getAllTest() throws Exception {
		List <Comments> showall = commentsrepo.findAll();
		
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/comment/getAll");
		
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.mapper.writeValueAsString(showall));
		
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
		
	
	
	

}
