package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, BigInteger> {




}
