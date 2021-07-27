package com.example.socialmediatests;
import org.junit.*;

import com.example.socialmedia.Message;
import com.example.socialmedia.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UnitTests {
	User matt = new User("Matt");
	User abby = new User("Abby");
	User charles = new User("Charles");
	
	Message message1 = new Message("Hello, social media users!", matt);
	Message message2 = new Message("Isn't is all so wonderful?!", abby);
	Message message3 = new Message("Indeed, Indeed", charles);
	Message message4 = new Message("I can see a lizard!", matt);
	Message message5 = new Message("It is climbing up the window!", matt);
	
	@Test
	public void testGetUsername() {
		assertEquals("Matt", matt.getUserName());
	}
	
	@Test
	public void testMessageText() {
		assertEquals("Hello, social media users!", message1.getMessage());
	}
	
	@Test
	public void testMessageUser() {
		assertEquals(matt, message1.getUser());
	}
	
	@Test
	public void testMessageDate() {
		assertEquals(new Date(), message1.getDate());
	}
	
	@Test
	public void testFollow() {
		matt.follow(abby);
		matt.follow(charles);
		assertTrue(abby.getFollowers().contains(matt));
		assertTrue(charles.getFollowers().contains(matt));
	}
	
	@Test 
	public void testTimeline() {
		matt.follow(abby);
		matt.follow(charles);
		
		matt.postMessage(message1);
		abby.postMessage(message2);
		charles.postMessage(message3);
		matt.postMessage(message4);
		matt.postMessage(message5);
		
		List<Message> testList = new ArrayList<Message>(Arrays.asList(message1, message2, message3, message4, message5));
		
		
		assertTrue(matt.getTimeline().containsAll(testList));
	}
}
