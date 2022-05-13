package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Notification;

import java.math.BigInteger;
import java.util.List;

public interface NotificationService {

    List<Notification> findAll();

    List<Notification> findAllByOwner(BigInteger owner);

    Notification save(Notification notification);

    Notification findById(BigInteger notificationId);

    Notification update(Notification notification);




}
