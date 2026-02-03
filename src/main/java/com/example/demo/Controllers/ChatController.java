package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChatService;

@RestController 
public class ChatController {

	private final ChatService chatService; 
	
	public ChatController(ChatService chatService) 
	{
		this.chatService = chatService; 
		
	} 
	
	@GetMapping("/chat")
	public String chat(@RequestParam String message) 
	{
		return chatService.getResponse(message); 
		
	}
}
