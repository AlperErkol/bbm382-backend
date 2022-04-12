package com.example.bbm382backend.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private BigInteger postId;

    @Column(name = "post_type")
    private EPost postType;

    @Column(name = "user_id")
    private BigInteger owner;

    @Column(name = "likes")
    private int likes;

    @Column(name = "comments")
    @OneToMany
    private List<User> commentList;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

}
