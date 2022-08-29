package com.softeem.junit.mybatis;


import com.softeem.dao.TStudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;

/**
 * description:
 *
 * @author lyming
 * @date 2020/12/22 9:46 下午
 */
public class MybatisTest {


    @Test
    public void testSqlSessionFactory(){
        SqlSession sqlSession = null;
        try {
            //利用Reader加载classPath下的mybatis-config.xml配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //利用构造者模式根据配置文件信息初始化SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                //如果type="POOLED",代表使用连接池,close则是将连接收回到连接池中
                //如果type="UNPOOLED",代表直连,close则会调用Connecttion.close方法关闭连接
                sqlSession.close();
            }
        }
    }


    @Test
    public void callPro(){
        SqlSession sqlSession = null;
        try {
            //利用Reader加载classPath下的mybatis-config.xml配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //利用构造者模式根据配置文件信息初始化SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            HashMap<String, Object> param = new HashMap<>();
            param.put("id",1);
            TStudentMapper mapper = sqlSession.getMapper(TStudentMapper.class);
            mapper.callSelectStu(param);
            System.out.println("查询结果:"+param.get("stuName"));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                //如果type="POOLED",代表使用连接池,close则是将连接收回到连接池中
                //如果type="UNPOOLED",代表直连,close则会调用Connecttion.close方法关闭连接
                sqlSession.close();
            }
        }
    }
}
