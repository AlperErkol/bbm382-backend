package com.example.bbm382backend.utils;



import java.util.Random;

public class UniqueFilename {
    private static final int MIN = 1;
    private static final int MAX = 600000;

    public String makeItUnique(String filename){
        Random random = new Random();
        for(int i = 0;i<4;i++){
            int rnd = random.nextInt(MAX) + MIN;
            filename+= Integer.toString(rnd);

        }
        return filename;
    }


}
