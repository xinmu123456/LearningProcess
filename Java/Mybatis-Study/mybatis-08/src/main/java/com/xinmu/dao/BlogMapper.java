package com.xinmu.dao;

import com.xinmu.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
     public int addBlog(Blog blog);

     //查询博客
    List<Blog> queryBlogIF(Map map);

    List<Blog>queryBlogChoose(Map map);


    //更新博客
    int updateBlog(Map map);

    //查询第1-2-3号博客
    List<Blog> queryBlogForeach(Map map);

}
