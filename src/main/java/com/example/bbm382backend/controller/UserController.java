package com.example.bbm382backend.controller;


import com.example.bbm382backend.model.User;
import com.example.bbm382backend.service.abstracts.UserService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET ALL USERS
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    //SIGN UP
    @PostMapping("/user")
    public User signUp(@RequestBody User user){
        return userService.signUpUser(user);
    }

    //SIGN IN
    @PostMapping("/login")
    public User signIn(@RequestBody User user){
        return userService.logInUser(user);
    }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable BigInteger userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/status")
    public List<User> findUsersByUserStatus(){
        return userService.findUserByStatus();
    }

    //TEST
    @GetMapping("/test")
    public boolean test(){
        return true;
    }





}
