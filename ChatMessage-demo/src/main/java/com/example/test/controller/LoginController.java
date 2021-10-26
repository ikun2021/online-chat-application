package com.example.test.controller;

import com.example.test.mapper.UserMapper;
import com.example.test.model.User;
import com.example.test.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    //不需要写login的逻辑，因为提交用户名，密码的时候，在走你设置的securityConfig以及authenticationSerivce！！！
}
