package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


public interface UserService {

    List<User> findAll();
    User signInUser(User user);
    User updateUser(User user);
    boolean logInUser(User user);


}
