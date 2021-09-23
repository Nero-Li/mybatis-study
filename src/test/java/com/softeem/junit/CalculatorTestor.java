package com.softeem.junit;

import com.softeem.utils.MybatisUtils;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import junit.framework.Test;
import org.apache.ibatis.session.SqlSession;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.DEFAULT)
//@FixMethodOrder(MethodSorters.JVM)
public class CalculatorTestor extends TestCase {

    public CalculatorTestor(String name) {
        super(name);
    }

    @Test
    public void add() {
        System.out.println(1);
    }

    @Test
    public void subtract() {
        System.out.println(4);
    }

    @Test
    public void mutiply() {
        System.out.println(3);
    }

//    @Test
//    public void devide() {
//        System.out.println(2);
//    }
//
//    @Test
//    public void testQueryAll() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MybatisUtils.createSession();
//            List<Teacher> list = sqlSession.selectList("teacher.queryAll");
//            for (Teacher t : list) {
//                System.out.println(t);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            MybatisUtils.closeSession(sqlSession);
//        }
//    }

//    @Test
//    public void testQueryById() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MybatisUtils.createSession();
//            Map map = new HashMap();
//            map.put("first", 1);
//            map.put("last", 2);
//            List<Teacher> list = sqlSession.selectList("teacher.queryById", 1);
//            for (Teacher t : list) {
//                System.out.println(t);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            MybatisUtils.closeSession(sqlSession);
//        }
//    }

    @Test
    public void testQueryByTeacherAndCourse() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
           List<Map> list = sqlSession.selectList("teacher.queryByTeacherAndCourse");
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }


//    public static Test suite() {
//        TestSuite suite = new TestSuite();
//        suite.addTest(new CalculatorTestor("subtract"));
//        suite.addTest(new CalculatorTestor("mutiply"));
//        suite.addTest(new CalculatorTestor("devide"));
//        suite.addTest(new CalculatorTestor("add"));
//        return suite;
//    }
}