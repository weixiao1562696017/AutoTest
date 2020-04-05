package com.study.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author Haley
 * @Date 2020/3/30 11:14
 **/
public class DataBaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        // 获取配置文件资源
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        // 获取SqlSessionFactory对象，使用类加载器加载xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 获取SqlSession对象（执行sql语句的对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
