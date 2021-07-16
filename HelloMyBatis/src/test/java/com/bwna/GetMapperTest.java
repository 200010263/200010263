package com.bwna;

import com.bwna.Dao.StudentDao;
import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GetMapperTest {

    /**
     使用mybatis的动态代理机制，用SqlSession.getMapper（dao接口.class）
     getMapper方法能获取dao接口对应的实现类对象
     */
    @Test
    public void getMapperTest1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1004, "唐三", "ts@qq.com", 12);
        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加了：" + num + "行数据");
        sqlSession.close();
    }

    @Test
    public void getMapperTest(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectStudents();
        for (Student stu: studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }
}
