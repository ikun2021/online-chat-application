package com.example.test.controller;

import com.example.test.model.ChatForm;
import com.example.test.service.MessageSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class ChatController {
    @Autowired
    private MessageSerivce messageSerivce;


    @GetMapping("/chat")
    public ModelAndView goChat(ChatForm chatForm,ModelAndView modelAndView,Authentication authentication){
        String username=authentication.getName();
        modelAndView.addObject("chatMessages",messageSerivce.getChatMessages(username));// 把chaMessages model传给template
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @PostMapping("/chat")
    public ModelAndView display(ChatForm chatForm, ModelAndView modelAndView, Authentication authentication){
        messageSerivce.addMessage(chatForm);
        String username=authentication.getName();
//      modelAndView.addObject("chatMessage",chatForm.getChatMessage());
        modelAndView.addObject("chatMessages",messageSerivce.getChatMessages(username));
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[]{"Say","Shout","Whisper"};
    }
}
