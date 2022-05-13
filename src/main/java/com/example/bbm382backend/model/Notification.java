package com.example.bbm382backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notifications")
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private BigInteger notificationId;

    @Column(name = "notification_post_id")
    private BigInteger notificationPostId;

    @Column(name = "owner")
    private BigInteger owner;

    @Column(name = "is_read")
    private Boolean isRead;


}
