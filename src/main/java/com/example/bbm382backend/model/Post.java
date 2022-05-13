package com.example.bbm382backend.model;


import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private BigInteger postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_type")
    private String postType;

    @Column(name = "user_id")
    private BigInteger owner;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_source")
    private String postSource;

    @Column(name = "post_event_start_date")
    private Date postEventStartDate;

    @Column(name = "post_event_end_date")
    private Date postEventEndDate;

    @Column(name = "post_event_type")
    private String postEventType;

    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Column(name = "can_apply")
    private Boolean canApply;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

}
