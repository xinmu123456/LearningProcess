package com.xinmu.net.URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xinmu
 * @date 2022/3/3 22:44
 * @description:
 */
public class URLDown {
    public static void main(String[] args) throws Exception {
        //下载地址
        URL url = new URL("https://m801.music.126.net/20220303231817/01c85abeaaa28f6c471bfbfb749ca2b7/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/10867616529/4ca3/3ef8/2e1b/66c7191fa5d2fe8093fc2d15d83e391f.m4a");

        //连接到这个资源
        HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos=new FileOutputStream("f.m4a");

        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){

            fos.write(buffer,0,len);//写出数据

        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
