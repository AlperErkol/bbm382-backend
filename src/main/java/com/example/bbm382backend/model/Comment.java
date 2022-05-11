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
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private BigInteger commentId;

    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "post_id")
    private BigInteger postId;

    @Column(name = "comment_content")
    private String commentContent;



}
