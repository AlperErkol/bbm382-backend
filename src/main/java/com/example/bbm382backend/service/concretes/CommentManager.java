package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Comment;
import com.example.bbm382backend.model.Post;
import com.example.bbm382backend.repository.CommentRepository;
import com.example.bbm382backend.repository.PostRepository;
import com.example.bbm382backend.service.abstracts.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CommentManager implements CommentService {

    private CommentRepository commentRepository;
    private PostManager postManager;
    @Autowired
    public CommentManager(CommentRepository commentRepository, PostManager postManager) {
        this.commentRepository = commentRepository;
        this.postManager = postManager;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByPostId(BigInteger belongsTo) {
        return commentRepository.findByBelongsTo(belongsTo);
    }

    @Override
    public Comment createComment(Comment comment) {

        commentRepository.save(comment);
        return comment;
    }
}
