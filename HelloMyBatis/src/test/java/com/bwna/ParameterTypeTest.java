package com.bwna;

import com.bwna.Dao.StudentDao;
import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ParameterTypeTest {

    //用student对象传入多个参数
    @Test
    public void TestBuStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1,"唐三","1111@qq.com",18);
        List<Student> studentList = dao.selectStudentByStudent(student);
        for(Student stu : studentList){
            System.out.println("学生是：" + stu);
        }
    }

    //传入多个参数
    @Test
    public void TestMultiparam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectStudentByMultiParam(1002, "张三");
        for(Student stu : student){
            System.out.println("学生是：" + stu);
        }
    }

    @Test
    public void parameterTypeTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1003);
        System.out.println(student);
    }

}
