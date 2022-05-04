package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User, BigInteger> {

    User findByEmail(String email);

    @Query(
            value = "select * from users u where u.user_status = false",
            nativeQuery = true
    )
    List<User> findUserByStatus();



}
