package com.example.bbm382backend.controller;

import com.example.bbm382backend.model.Frame;
import com.example.bbm382backend.service.abstracts.FrameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/frames")
public class FrameController {


    private FrameService frameService;

    public FrameController(FrameService frameService){
        this.frameService = frameService;
    }

    @GetMapping("/all")
    public List<Frame> findAll(){
        return frameService.findAll();
    }

    @PostMapping("/frame")
    public Frame save(@RequestBody Frame frame){
        return frameService.save(frame);
    }

    // Testing Controller
    @GetMapping("/test")
    public String test(){
        return "I'm working..";
    }






}
