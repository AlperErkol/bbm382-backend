package com.example.bbm382backend.controller;


import com.example.bbm382backend.model.Comment;
import com.example.bbm382backend.service.abstracts.CommentService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/comments")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }


    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment){
        return this.commentService.createComment(comment);
    }

    @PostMapping("/comment/{belongsTo}")
    public List<Comment> findCommentsByBelongsTo(@PathVariable BigInteger belongsTo){
        return commentService.findByPostId(belongsTo);
    }

    @GetMapping("/test")
    public String test(){
        return "I'm working";
    }

}
