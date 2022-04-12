package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.User;
import com.example.bbm382backend.repository.UserRepository;
import com.example.bbm382backend.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signInUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean logInUser(User user) {
        return false;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(BigInteger userId){
        return userRepository.findById(userId).get();
    }

    public User deleteUser(BigInteger userId) {
        User user = findUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }
}
