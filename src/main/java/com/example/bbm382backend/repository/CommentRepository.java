package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, BigInteger> {

    List<Comment> findByBelongsTo(BigInteger belongsTo);

}
