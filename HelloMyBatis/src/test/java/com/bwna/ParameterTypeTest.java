package com.bwna;

import com.bwna.Dao.StudentDao;
import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ParameterTypeTest {
    @Test
    public void parameterTypeTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1003);
        System.out.println(student);
    }

}
