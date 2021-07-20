package com.bwna;

import com.bwna.dao.StudentDao;
import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class ResultMapTest {

    @Test
    public void testLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //定义好模糊查询的like的内容
        String name = "%三";
        List<Student> student = dao.selectLikeStudent(name);
        for(Student stu: student){
            System.out.println(stu);
        }
    }
    @Test
    public void testMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectAllStudent();
        for(Student stu: student){
            System.out.println(stu);
        }
    }
}
