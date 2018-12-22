package com.example.yyl.httptest.feature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamTool {
    //读取流中的数据
    public static byte[] read(InputStream inputStream)throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1){
                outStream.write(buffer,0,len);
        }
        inputStream.close();//关闭输入流
        return outStream.toByteArray();//返回数据
    }
}
