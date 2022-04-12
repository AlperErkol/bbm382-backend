package com.example.bbm382backend.controller;


import com.example.bbm382backend.model.User;
import com.example.bbm382backend.service.abstracts.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/user")
    public User signIn(@RequestBody User user){
        return userService.signInUser(user);
    }

    @GetMapping("/test")
    public boolean test(){
        return true;
    }





}
