package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Post;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


public interface PostService {

    List<Post> findAll();
    Post findPostByPostId(BigInteger postId);
    Post deletePost(BigInteger postId);
    Post createPost(Post post);
    Post updatePost(Post post);

}
