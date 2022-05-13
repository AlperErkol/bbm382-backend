package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Comment;

import java.math.BigInteger;
import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    List<Comment> findByPostId(BigInteger belongsTo);
    Comment createComment(Comment comment);

}
