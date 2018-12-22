package com.example.yyl.test2.service;

import java.io.FileOutputStream;
import android.content.Context;

public class FileService {
    private Context context;
    public FileService(Context context){
        this.context = context;
    }
    public void save(String path,String content) throws Exception{
        FileOutputStream outputStream = context.openFileOutput(path,Context.MODE_PRIVATE);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
}
