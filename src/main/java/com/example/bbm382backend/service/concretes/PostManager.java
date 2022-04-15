package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.*;
import com.example.bbm382backend.repository.PostRepository;
import com.example.bbm382backend.service.abstracts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PostManager implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostManager(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
    }

    @Override
    public Post findPostByPostId(BigInteger postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public Post deletePost(BigInteger postId) {

        Post post = findPostByPostId(postId);
        if(post==null){
            return null;
        }else{
            postRepository.deleteById(postId);
            return post;
        }
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        Post p = findPostByPostId(post.getPostId());
        p.setPostContent(post.getPostContent());
        return postRepository.save(p);
    }
}
