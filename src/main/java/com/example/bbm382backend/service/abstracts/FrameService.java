package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Frame;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

public interface FrameService {

    List<Frame> findAll();

    List<Frame> findByPostId(BigInteger postId);

    Frame findByUserId();

    String uploadFile(MultipartFile file);

    Boolean saveProfilePhoto(MultipartFile file, BigInteger userId);



}
