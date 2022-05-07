package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Frame;
import com.example.bbm382backend.repository.FrameRepository;
import com.example.bbm382backend.service.abstracts.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrameManager implements FrameService {

    private FrameRepository frameRepository;

    @Autowired
    public FrameManager(FrameRepository frameRepository){
        this.frameRepository = frameRepository;
    }


    @Override
    public List<Frame> findAll() {
        return null;
    }

    @Override
    public List<Frame> findByPostId() {
        return null;
    }

    @Override
    public Frame findByUserId() {
        return null;
    }

    @Override
    public Frame save(Frame frame) {
        return this.frameRepository.save(frame);
    }
}
