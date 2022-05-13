package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, BigInteger> {


    List<Notification> findAllByOwner(BigInteger owner);


}
