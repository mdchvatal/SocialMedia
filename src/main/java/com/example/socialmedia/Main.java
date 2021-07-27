package com.example.socialmedia;

public class Main {
	public static void main(String[] args) {
		User matt = new User("Matt");
		User abby = new User("Abby");
		User charles = new User("Charles");
		
		Message message1 = new Message("Hello, social media users!", matt);
		Message message2 = new Message("Isn't is all so wonderful?!", abby);
		Message message3 = new Message("Indeed, Indeed", charles);
		Message message4 = new Message("I can see a lizard!", matt);
		Message message5 = new Message("It is climbing up the window!", matt);
		
		matt.follow(abby);
		matt.follow(charles);
		
		matt.postMessage(message1);
		abby.postMessage(message2);
		charles.postMessage(message3);
		matt.postMessage(message4);
		matt.postMessage(message5);
		
		matt.displayTimeline();
	}
}
