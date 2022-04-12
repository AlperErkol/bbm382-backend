package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Post;
import com.example.bbm382backend.service.abstracts.PostService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PostManager implements PostService {
    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findPostByPostId(BigInteger postId) {
        return null;
    }

    @Override
    public Post deletePost(BigInteger postId) {
        return null;
    }

    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }
}
