package com.example.test.service;

import com.example.test.mapper.MessagesMapper;
import com.example.test.model.ChatForm;
import com.example.test.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageSerivce {
    @Autowired
    private MessagesMapper messagesMapper;

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messagesMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages(String username){

        return messagesMapper.findByName(username);
    }
}
