package com.qa.hobbyproject;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbyproject.ENTITES.User;
import com.qa.hobbyproject.REPOSITORY.UserRepo;
import com.qa.hobbyproject.SERVICE.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class UserTest {
		
	@Autowired
	private MockMvc mock;
		
	@Autowired
	UserRepo userrepo;
		
	@Autowired
	UserService userservice;
		
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
		
		
	public User testUser;
	public User testUserwithID;
	
	@Before
	public void init() {
		this.userrepo.deleteAll();
		this.testUser = new User("name", "email@eamil.com");
		this.testUserwithID = this.userrepo.save(this.testUserwithID);
	}
	@Test
	void test() throws Exception{
		this.testUser = new User("name", "White@gmail.com");
		this.testUserwithID = this.userrepo.save(this.testUser);
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.POST, "/user/new");
		
		mockRequest.contentType(MediaType.APPLICATION_JSON)
			.content(this.mapper.writeValueAsString(testUser))
				.accept(MediaType.APPLICATION_JSON);
		
		//need to tell this test what http is getting pinged at it(for e.g json, other metadata)
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		
		// check the content we are getting back
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.mapper.writeValueAsString(testUserwithID));
	
		//checking status = header and checking content = body
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

}
