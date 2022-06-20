package com.xinmu.servlet;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * author: xinmu
 * date: 2022/3/27
 * time: 13:31
 */


public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断上传的文件是普通的表单还是带文件的表单
        if(!ServletFileUpload.isMultipartContent(req)){
            return;//中止方法的运行,说明这是一个普通的表单,直接返回
        }

        //创建上传文件的保存路径,建议在web-inf的路径下,比较安全,用户无法直接访问上传的文件
        String uploadPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile=new File(uploadPath);
        if (!uploadFile.exists()){
            uploadFile.mkdirs();//创建这个目录
        }

        //缓存,临时文件
        //临时路径,假如文件超过了预期,我们就把它放到一个临时的文件中,过几天自动删除,或者提心用户转存为永久
        String tmpPath=this.getServletContext().getRealPath("/WEB-INF/tmp");
        File file=new File(tmpPath);
        if (!file.exists()){
            file.mkdirs();//创建这个临时目录
        }

        //1.创建DiskFileItemFactory对象,处理文件上传路径或者大小的限制
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //通过这个工厂设置一个缓存区,当上传的文件大于这个缓冲区时,将它放到临时文件中
        factory.setSizeThreshold(1024*1024);//缓存区的大小为1mb
        factory.setRepository(file);//临时目录的保存目录,需要一个file

        //2.获取servletFileUpLoad
        ServletFileUpload upload=new ServletFileUpload(factory);




    }
}
