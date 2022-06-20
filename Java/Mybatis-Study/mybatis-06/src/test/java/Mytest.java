import com.xinmu.dao.StudentMapper;
import com.xinmu.dao.TeacherMapper;
import com.xinmu.pojo.Student;
import com.xinmu.pojo.Teacher;
import com.xinmu.untils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 17:14
 */


public class Mytest {
    public static void main(String[] args) {
        SqlSession sqlSession= MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();

    }
    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtils.getSqlsession();
        StudentMapper mapper2 = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper2.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();

    }

}
