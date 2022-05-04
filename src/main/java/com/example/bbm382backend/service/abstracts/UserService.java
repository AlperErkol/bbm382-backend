package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


public interface UserService {

    List<User> findAll();
    User signUpUser(User user);
    User updateUser(User user);
    User logInUser(User user);
    User findUserById(BigInteger userId);
    List<User> findUserByStatus();

}
