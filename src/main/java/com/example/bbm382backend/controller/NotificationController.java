package com.example.bbm382backend.controller;


import com.example.bbm382backend.model.Notification;
import com.example.bbm382backend.service.abstracts.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping("/all/{owner}")
    public List<Notification> findAllByOwner(@PathVariable BigInteger owner){
        return this.notificationService.findAllByOwner(owner);
    }

    @GetMapping("/test")
    public String test(){
        return "I'm working..";
    }




}
