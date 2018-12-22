package com.example.yyl.httptest.feature;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageService {
    //获取网络图片路径
    public static byte[] getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();//基于http协议的连接对象
        connection.setConnectTimeout(5000);//请求超时时间
        connection.setRequestMethod("GET");//设置set/get方法
        if (connection.getResponseCode() == 200){
            //请求成功
            InputStream inStream = connection.getInputStream();
            return StreamTool.read(inStream);//利用一个公共工具类
        }
        return null;
    }
}
