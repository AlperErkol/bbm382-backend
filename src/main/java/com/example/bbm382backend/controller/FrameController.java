package com.example.bbm382backend.controller;

import com.example.bbm382backend.model.Frame;
import com.example.bbm382backend.model.User;
import com.example.bbm382backend.service.abstracts.FrameService;
import com.example.bbm382backend.utils.FileUploadUtil;
import com.example.bbm382backend.utils.UniqueFilename;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String uploadToDB(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String fileExtension = FileUploadUtil.getExtension(filename);
        filename = filename.replace(fileExtension, "");

        UniqueFilename uniqueFilename = new UniqueFilename();

        String uFilename = uniqueFilename.makeItUnique(filename);
        uFilename+=fileExtension;

        String uploadDir = "user-photos";
        FileUploadUtil.saveFile(uploadDir, uFilename, file);

        //user.setUserImage(uFilename);
        return uFilename;
    }

    // Testing Controller
    @GetMapping("/test")
    public String test(){
        return "I'm working..";
    }






}
