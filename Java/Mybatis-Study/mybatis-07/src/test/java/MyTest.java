import com.xinmu.pojo.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.xinmu.dao.TeacherMapper;
import com.xinmu.untils.MybatisUtils;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 20:15
 */


public class MyTest {

    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);

       // List<Teacher> teacherList = mapper.getTeacher();

//        for (Teacher teacher : teacherList) {
//            System.out.println(teacher);
//        }

        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlsession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        sqlsession.close();
    }
}
