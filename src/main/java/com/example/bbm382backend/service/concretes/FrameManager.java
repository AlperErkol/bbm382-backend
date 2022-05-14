package com.example.bbm382backend.service.concretes;

import com.example.bbm382backend.model.Frame;
import com.example.bbm382backend.model.User;
import com.example.bbm382backend.repository.FrameRepository;
import com.example.bbm382backend.repository.UserRepository;
import com.example.bbm382backend.service.abstracts.FrameService;
import com.example.bbm382backend.utils.FileUploadUtil;
import com.example.bbm382backend.utils.UniqueFilename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
public class FrameManager implements FrameService {

    private FrameRepository frameRepository;
    private UserRepository userRepository;

    @Autowired
    public FrameManager(FrameRepository frameRepository, UserRepository userRepository){
        this.frameRepository = frameRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Frame> findAll() {
        return null;
    }

    @Override
    public List<Frame> findByPostId(BigInteger postId) {
        return this.frameRepository.findByPostId(postId);
    }

    @Override
    public Frame findByUserId() {
        return null;
    }

    @Override
    public String uploadFile(MultipartFile file) {


        String filename = file.getOriginalFilename();
        String fileExtension = FileUploadUtil.getExtension(filename);
        filename = filename.replace(fileExtension, "");

        UniqueFilename uniqueFilename = new UniqueFilename();

        String uFilename = uniqueFilename.makeItUnique(filename);
        uFilename+=fileExtension;

        String uploadDir = "user-photos";
        try {
            FileUploadUtil.saveFile(uploadDir, uFilename, file);
            Frame frame = new Frame();
            frame.setFramePath(uFilename);
            this.frameRepository.save(frame);
            return uFilename;

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public Boolean saveProfilePhoto(MultipartFile file, BigInteger userId) {


        User u = this.userRepository.findById(userId).get();

        String filename = file.getOriginalFilename();
        String fileExtension = FileUploadUtil.getExtension(filename);
        filename = filename.replace(fileExtension, "");

        UniqueFilename uniqueFilename = new UniqueFilename();

        String uFilename = uniqueFilename.makeItUnique(filename);
        uFilename+=fileExtension;

        String uploadDir = "C:/Users/z004jt0m/Desktop/js_projects/bbm382-ui/public/user-photos";
        try {
            FileUploadUtil.saveFile(uploadDir, uFilename, file);
            u.setUserImage(uFilename);

            this.userRepository.save(u);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }





    }
}
