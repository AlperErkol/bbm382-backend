package com.example.bbm382backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

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

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "belongs_to")
    private BigInteger belongsTo;

    @Column(name = "owner")
    private BigInteger owner;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;



}
