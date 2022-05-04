package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.User;
import com.example.bbm382backend.repository.UserRepository;
import com.example.bbm382backend.security.PasswordConfig;
import com.example.bbm382backend.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private PasswordConfig passwordConfig;

    @Autowired
    public UserManager(UserRepository userRepository, PasswordConfig passwordConfig){
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signUpUser(User user) {

        //checks if there is a given mail.
        User isUser = findByEmail(user.getEmail());
        if(isUser==null){
            String bcryptedPassword = this.passwordConfig.passwordEncoder().encode(user.getPassword());
            user.setPassword(bcryptedPassword);
            return userRepository.save(user);
        }else{
            return null;
        }

    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User logInUser(User user) {

        //checks if there is a given user.
        User isUser = findByEmail(user.getEmail());

        if(isUser==null){
            return null;
        }else{

            boolean isPasswordMatches = this.passwordConfig.passwordEncoder().matches(user.getPassword(),isUser.getPassword());

            if(isPasswordMatches){
                return isUser;
            }else{
                return null;
            }
        }

    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(BigInteger userId){
        return userRepository.findById(userId).get();
    }

    public List<User> findUserByStatus() {
        return userRepository.findUserByStatus();
    }

    public User deleteUser(BigInteger userId) {
        User user = findUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }
}
