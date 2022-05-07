package com.example.bbm382backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "sessions")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private BigInteger sessionId;

    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "session_uid")
    private String sessionUid;

}
