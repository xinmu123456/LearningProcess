package com.xinmu.ThreadDemo01;

import com.xinmu.Thread.Demo.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author xinmu
 * @date 2022/2/24 17:27
 * @description:
 */
public class TestCallable implements Callable<Boolean> {

    private String url;//网络图片的地址
    private String name;//保存的文件名
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("https://lmg.jj20.com/up/allimg/1114/0G020114924/200G0114924-3-1200.jpg","1.jpg");
        TestCallable t2=new TestCallable("https://lmg.jj20.com/up/allimg/1114/0G020114924/200G0114924-3-1200.jpg","2.jpg");
        TestCallable t3=new TestCallable("https://lmg.jj20.com/up/allimg/1114/0G020114924/200G0114924-3-1200.jpg","3.jpg");

        ExecutorService ser= Executors.newFixedThreadPool(3);


        Future<Boolean> r1= ser.submit(t1);
        Future<Boolean> r2= ser.submit(t2);
        Future<Boolean> r3= ser.submit(t3);

        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();

        ser.shutdown();

    }

}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常downloader方法出现问题");
        }
    }
}