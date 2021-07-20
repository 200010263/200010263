package com.bwna;

import com.bwna.dao.StudentDao;
import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DongTaiSql {

    //分页测试
    @Test
    public void pageHelperTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //获取第1页，共2条内容
        PageHelper.startPage(1,2);
        List<Student> studentList = dao.selectAllStudentsPageHelper();
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }


    @Test
    public void dongIfTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1001,"张三","111@qq.com",18);
        List<Student> studentList = dao.selectDongIf(student);
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void dongWhereTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1001,"王老五","111@qq.com",18);
        List<Student> studentList = dao.selectDongWhere(student);
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }

}
