package com.example.bbm382backend.repository;

import com.example.bbm382backend.model.Frame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface FrameRepository extends JpaRepository<Frame, BigInteger> {

    List<Frame> findByPostId(BigInteger postId);


}
