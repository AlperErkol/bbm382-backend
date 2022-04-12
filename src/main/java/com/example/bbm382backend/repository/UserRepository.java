package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {

    User findByEmail(String email);

}
