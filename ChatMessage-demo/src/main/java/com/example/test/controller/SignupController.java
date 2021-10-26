package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.service.UserSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
    @Autowired
    private UserSerivice userSerivice;

    @PostMapping("/signup")
    public String register(@ModelAttribute User user, ModelAndView modelAndView){
        String signupError=null;
        if(userSerivice.isUsernameAvailable(user.getUsername())){
            userSerivice.createUser(user);
            modelAndView.addObject("signupSuccess",true);
        }else{
            signupError="this username already exists";
            modelAndView.addObject("signupError",signupError);
        }
        return "signup";
    }

    @GetMapping("/signup")
    public String signupView(User user){
        return "signup";
    }
}
