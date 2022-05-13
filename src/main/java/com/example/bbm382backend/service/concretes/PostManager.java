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
    private UserManager userManager;
    private NotificationManager notificationManager;

    @Autowired
    public PostManager(PostRepository postRepository, UserManager userManager, NotificationManager notificationManager){
        this.postRepository = postRepository;
        this.userManager = userManager;
        this.notificationManager = notificationManager;
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

        Post newPost = postRepository.save(post);

        if(post.getPostType().equalsIgnoreCase("announcement")){

            List<User> userList = userManager.findAll();
            int userListSize = userList.size();

            for(int i = 0;i<userListSize;i++){
                Notification notification = new Notification();
                BigInteger userId = userList.get(i).getUserId();
                notification.setOwner(userId);
                notification.setNotificationPostId(newPost.getPostId());
                notification.setIsRead(false);
                notificationManager.save(notification);
            }
        }

        return newPost;

    }

    @Override
    public Post updatePost(Post post) {
        Post p = findPostByPostId(post.getPostId());
        p.setPostContent(post.getPostContent());
        return postRepository.save(p);
    }
}
