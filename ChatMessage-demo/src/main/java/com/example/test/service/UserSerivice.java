package com.example.test.service;

import com.example.test.mapper.UserMapper;
import com.example.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserSerivice {
     @Autowired
     private HashService hashSerivce;
     @Autowired
     private UserMapper userMapper;

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashSerivce.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));

    }

    public User findByName(String username){
        return userMapper.findByName(username);
    }

    public boolean isUsernameAvailable(String username){
        return (userMapper.findByName(username)==null);
    }
}
