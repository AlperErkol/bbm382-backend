package com.example.bbm382backend.controller;

import com.example.bbm382backend.model.Frame;
import com.example.bbm382backend.service.abstracts.FrameService;
import com.example.bbm382backend.utils.FileUploadUtil;
import com.example.bbm382backend.utils.UniqueFilename;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
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

    @PostMapping("/frame/{userId}")
    public Boolean uploadProfilePhoto(@RequestParam("file") MultipartFile file, @PathVariable BigInteger userId) throws IOException {
        return frameService.saveProfilePhoto(file, userId);
    }

    @PostMapping("/frame")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return frameService.uploadFile(file);
    }

    @PostMapping("/frameById/{postId}")
    public List<Frame> findFrameByPostId(@PathVariable BigInteger postId){

        return this.frameService.findByPostId(postId);

    }

    // Testing Controller
    @GetMapping("/test")
    public String test(){
        return "I'm working..";
    }






}
