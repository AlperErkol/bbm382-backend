package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Notification;
import com.example.bbm382backend.repository.NotificationRepository;
import com.example.bbm382backend.service.abstracts.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class NotificationManager implements NotificationService {

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationManager(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;

    }


    public List<Notification> findAllByOwner(BigInteger owner) {
        return notificationRepository.findAllByOwner(owner);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findById(BigInteger notificationId) {
        return notificationRepository.findById(notificationId).get();
    }
}
