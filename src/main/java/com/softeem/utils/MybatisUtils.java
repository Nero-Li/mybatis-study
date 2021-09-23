package com.softeem.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * description:
 *
 * @author lyming
 * @date 2020/12/22 10:11 下午
 */
public class MybatisUtils {
    /**
     * 利用static,让sqlSessionFactory不属于对象而属于类,保证全局唯一
     */
    private static SqlSessionFactory sqlSessionFactory = null;

    //初始化静态对象
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            //抛出去,要别的使用到这段代码的其他代码知道有这个异常
            //ExceptionInInitializerError:初始化异常
            throw new ExceptionInInitializerError(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * 创建sqlSession对象
     *
     * @return SqlSession
     */
    public static SqlSession createSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭连接
     *
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
