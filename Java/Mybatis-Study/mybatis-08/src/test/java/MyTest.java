import com.xinmu.dao.BlogMapper;
import com.xinmu.pojo.Blog;
import com.xinmu.untils.IDUntils;
import com.xinmu.untils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 21:55
 */


public class MyTest {

    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(IDUntils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUntils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUntils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUntils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
       // map.put("title","Java如此简单2");
        map.put("author","狂神说2");
        map.put("id","f06f90cacbe440819ffbe988a080de65");

//        map.put("title","Java如此简单");
//        map.put("author","狂神说");

        //List<Blog> blogs=mapper.queryBlogChoose(map);

//        for (Blog blog : blogs) {
//            System.out.println(blog);
//        }

//        mapper.updateBlog(map);

        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();

    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap<>();

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);



        map.put("ids",ids);

        mapper.queryBlogForeach(map);


        sqlSession.close();

    }

}
