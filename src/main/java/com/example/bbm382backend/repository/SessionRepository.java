package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;

public interface SessionRepository extends JpaRepository<UserSession, BigInteger> {


}
