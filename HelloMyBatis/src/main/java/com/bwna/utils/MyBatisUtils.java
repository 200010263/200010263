package com.bwna.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

/**
* @Desc: 创建一个工具类简化操作
* @param:
* @return:
*/
public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    static{
        String config = "mybatis.xml";//与自己项目中的mybatis主配置文件名字一样
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //通过SqlSessionFactoryBuilder创建sqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession对象的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if(factory != null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }

}
