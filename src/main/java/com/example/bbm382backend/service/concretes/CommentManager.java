package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Comment;
import com.example.bbm382backend.model.Post;
import com.example.bbm382backend.repository.CommentRepository;
import com.example.bbm382backend.repository.PostRepository;
import com.example.bbm382backend.service.abstracts.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CommentManager implements CommentService {



    private CommentRepository commentRepository;
    private PostManager postManager;
    @Autowired
    public CommentManager(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {

        BigInteger postId = comment.getPostId();

        Post post = postManager.findPostByPostId(postId);
        List<Comment> commentList = post.getCommentList();
        commentList.add(comment);
        post.setCommentList(commentList);

        postManager.updatePost(post);

        commentRepository.save(comment);

        return comment;
    }
}
