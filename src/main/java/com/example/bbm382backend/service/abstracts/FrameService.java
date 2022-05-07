package com.example.bbm382backend.service.abstracts;

import com.example.bbm382backend.model.Frame;

import java.util.List;

public interface FrameService {

    List<Frame> findAll();

    List<Frame> findByPostId();

    Frame findByUserId();

    Frame save(Frame frame);



}
