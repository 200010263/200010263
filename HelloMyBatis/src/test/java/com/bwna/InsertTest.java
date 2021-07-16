package com.bwna;

import com.bwna.domian.Student;
import com.bwna.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InsertTest {

    @Test
    public void SecondTest(){
        //5,获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //6，指定要执行的sql语句的标识：sql映射文件中的namespace + "." + 标签的id
        String sqlId = "com.bwna.Dao.StudentDao" + "." + "selectStudents";
        //7，执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8，输出结果
        for(Student stu: studentList){
            System.out.println("查询的学生：" + stu);
        }
        //9，关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void InsertTest() throws IOException {
        //1,定义mybatis主配置文件的名称，从target/classes开始
        String config = "mybatis.xml";
        //2,读取这个文件的信息
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3,创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4,创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(inputStream);
        //5,获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //6，指定要执行的sql语句的标识：sql映射文件中的namespace + "." + 标签的id
        String sqlId = "com.bwna.Dao.StudentDao" + "." + "insertStudent";
        //7，执行sql语句，通过sqlId找到语句
        //这里需要构造一个学生对象
        Student student = new Student(1003,"王老五","wlu@qq.com",11);
        int num = sqlSession.insert(sqlId,student);
        //这里注意：mybatis默认不提交事务，需要手动提交，insert，update，delete操作都要
        sqlSession.commit();
        //8，输出结果
        System.out.println("添加的行数：" + num);
        //9，关闭SqlSession对象
        sqlSession.close();
    }

}
