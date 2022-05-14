package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.PasswordC;
import com.example.bbm382backend.model.User;
import com.example.bbm382backend.model.UserSession;
import com.example.bbm382backend.repository.SessionRepository;
import com.example.bbm382backend.repository.UserRepository;
import com.example.bbm382backend.security.PasswordConfig;
import com.example.bbm382backend.service.abstracts.UserService;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private PasswordConfig passwordConfig;
    private SessionRepository sessionRepository;

    private ModelMapper mapper;

    @Autowired
    public UserManager(UserRepository userRepository, PasswordConfig passwordConfig, SessionRepository sessionRepository, ModelMapper mapper){
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
        this.sessionRepository = sessionRepository;
        this.mapper = mapper;
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

        User u = findUserById(user.getUserId());
        if(user.getEmail() != null){
            u.setEmail(user.getEmail());
        }
        if(user.getUserType() != null){
            u.setUserType(user.getUserType());
        }
        if(user.getFirstName() != null){
            u.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            u.setLastName(user.getLastName());
        }
        if(user.getCompany() != null){
            u.setCompany(user.getCompany());
        }
        if(user.getPosition() != null){
            u.setPosition(user.getPosition());
        }

        return this.userRepository.save(u);
    }

    @Override
    public User logInUser(User user) {

        //checks if there is a given user.
        User isUser = findByEmail(user.getEmail());



        if(isUser==null){
            return null;
        }else{

            boolean isPasswordMatches = this.passwordConfig.passwordEncoder().matches(user.getPassword(),isUser.getPassword());
            boolean isUserActive = isUser.isUserStatus();


            if(isPasswordMatches && isUserActive){
                String userId = String.valueOf(user.getUserId());
                String sessionUid = this.passwordConfig.passwordEncoder().encode(userId);
                UserSession userSession = new UserSession();

                if(isUser.getUserId() != null){
                    userSession.setUserId(isUser.getUserId());
                    userSession.setSessionUid(sessionUid);
                    sessionRepository.save(userSession);
                }

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

    @Override
    public List<User> findActiveUsers() {
        return userRepository.findActiveUser();
    }

    @Override
    public Boolean acceptPendingRequest(BigInteger userId) {

        User user = userRepository.findById(userId).get();
        user.setUserStatus(true);
        userRepository.save(user);
        return true;

    }

    @Override
    public Boolean declinePendingRequest(BigInteger userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public Boolean changePassword(PasswordC passwordC) {

        User u = findUserById(passwordC.getUserId());
        String oldPassword = passwordC.getOldPassword();
        boolean isMatch = this.passwordConfig.passwordEncoder().matches(oldPassword,u.getPassword());
        if(isMatch)
        {
            if(passwordC.getNewPassword().equals(passwordC.getNewPasswordConfirm()))
            {
                String bcryptedPassword = this.passwordConfig.passwordEncoder().encode(passwordC.getNewPassword());
                u.setPassword(bcryptedPassword);
                System.out.println("Buradayım....");

                userRepository.save(u);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }

    public User deleteUser(BigInteger userId) {
        User user = findUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }
}
