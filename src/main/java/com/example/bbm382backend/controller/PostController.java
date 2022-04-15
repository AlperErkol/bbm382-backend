package com.example.bbm382backend.controller;


import com.example.bbm382backend.model.Post;
import com.example.bbm382backend.service.abstracts.PostService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return postService.findAll();
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PostMapping("/updatePost")
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/post/{postId}")
    public Post deletePost(@PathVariable BigInteger postId){
        return postService.deletePost(postId);
    }

    @GetMapping("/test")
    public String test(){
        return "i'm working on post controller";
    }
}
