/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.chat.demochattapp;

/**
 *
 * @author ADMIN
 */import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessagePojo sendMessage(@Payload ChatMessagePojo chatMessagePojo) {
        return chatMessagePojo;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
        
// Add username in web socket session
    headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
        return chatMessagePojo;
    }
}
