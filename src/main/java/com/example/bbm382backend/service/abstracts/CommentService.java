package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment createComment(Comment comment);

}
