package com.softeem.entity;

import com.softeem.dto.CourseStudentDTO;
import com.softeem.dto.StudentCourseDTO;
import com.softeem.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CourseTest {

    /**
     * 一对多
     */
    @Test
    public void testOneToMany() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            //本次成功插入(影响)的总数
            List<CourseStudentDTO> list = sqlSession.selectList("course.selectOneToMany");

            for (CourseStudentDTO dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 一对多select
     */
    @Test
    public void testOneToMany2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            //本次成功插入(影响)的总数
            List<CourseStudentDTO> list = sqlSession.selectList("course.selectOneToMany2");

            for (CourseStudentDTO dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

}