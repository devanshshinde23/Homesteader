package com.example.demo.Dao;

import org.springframework.stereotype.Service;

import com.example.demo.Service.ChatService;

@Service
public class ChatDao implements ChatService  {

	
	    @Override
	    public String getResponse(String userMessage) {
	        if (userMessage == null || userMessage.isBlank()) {
	            return "Please say something!";
	        }

	        String msg = userMessage.toLowerCase();

	        if (msg.contains("hello") || msg.contains("hi")) {
	            return "Hello! How can I help you today?";
	        } else if (msg.contains("crop")) {
	            return "You can manage crops in the Homesteader crop module.";
	        } else if (msg.contains("inventory")) {
	            return "Check the inventory dashboard for stock updates.";
	        } else if (msg.contains("bye")) {
	            return "Goodbye! Have a great day.";
	        } else {
	            return "Sorry, I don’t understand. Try asking about crops, inventory, or greetings.";
	        }
	    }
	

}
