package com.softeem.entity;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.softeem.dto.StudentCourseDTO;
import com.softeem.dto.StudentCourseDTO2;
import com.softeem.dto.StudentDTO;
import com.softeem.dto.StudentDTO2;
import com.softeem.dto.StudentDTO3;
import com.softeem.io.MyVFS;
import com.softeem.utils.MybatisUtils;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentTest {
//    private static final Logger log = LoggerFactory.getLogger(StudentTest.class);
//    @BeforeClass
//    public static void beforeClass(){
//        log.debug("========我是谁");
//        VFS.addImplClass(MyVFS.class);
//    }

    @Test
    public void testQueryAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Student> list = sqlSession.selectList("student.queryAll");
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * SQL传参
     */
    @Test
    public void testQueryById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            Student student = sqlSession.selectOne("student.queryById", 1);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * SQL传参(通过Map传多个参数)
     */
    @Test
    public void testQueryByIdRange() {
        SqlSession sqlSession = null;
        try {
            Map param = new HashMap();
            param.put("minId", 1);
            param.put("maxId", 3);
            sqlSession = MybatisUtils.createSession();
            List<Student> list = sqlSession.selectList("student.queryByIdRange", param);
//            queryByIdRange全局唯一,所以可以不加namespace
//            List<Student> list = sqlSession.selectList("queryByIdRange",param);
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 多表联合查询,用Map来接收返回
     */
    @Test
    public void testQueryStudentMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Map> list = sqlSession.selectList("student.queryStudentMap");
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryStudentDTO() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<StudentDTO> list = sqlSession.selectList("student.queryStudentMap");
            for (StudentDTO dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
//            Student student = new Student();
            StudentUUID student = new StudentUUID();
            student.setNickname("测试4");
            student.setRealname("真*测试3");
            student.setMobile("13XXXXXXXXX");
            student.setSex(0);
            student.setCourseId(1);
//            1995-6-6
//            student.setBirthday(new Date(95,5,6));
            student.setBirthday(LocalDate.of(1995, 6, 6));
            //本次成功插入(影响)的总数
            int num = sqlSession.insert("student.insertStudentUUID", student);
            sqlSession.commit();
            System.out.println(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testUpdateStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            Student student = sqlSession.selectOne("student.queryById", 12);
            student.setNickname("我被update修改了");
            int num = sqlSession.insert("student.updateStudent", student);
            System.out.println(num);
            sqlSession.commit();
            System.out.println(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            int num = sqlSession.delete("student.deleteById", 12);
            System.out.println(num);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }


    @Test
    public void test_QueryById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Student> list = sqlSession.selectList("student._queryById", "'' or 1=1");
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void test_dynamicSql() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            Student student = new Student();
            student.setSex(2);
            List<StudentDTO2> list = sqlSession.selectList("student.dynamicSql",student);
//            List<StudentDTO2> list = sqlSession.selectList("student.dynamicSql");
            for (StudentDTO2 s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryByIdWithSql() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            Student student = sqlSession.selectOne("student.queryByIdWithSql", 1);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryStudentsByIds() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            StudentDTO3 studentDTO3 = new StudentDTO3();
            studentDTO3.setIds(ids);
            List<Student> list = sqlSession.selectList("student.queryStudentsByIds", studentDTO3);
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryStudentsByList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
                List<Student> list = sqlSession.selectList("student.queryStudentsByList", ids);
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryStudentsByArray() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            int[] ids = new int[]{1,3,5};
            List<Student> list = sqlSession.selectList("student.queryStudentsByArray", ids);
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testQueryStudentsByMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            int[] ids = new int[]{1,3,5};
            Map<String, Object> map = new HashMap<>();
            map.put("aaa",ids);
            List<Student> list = sqlSession.selectList("student.queryStudentsByMap", map);
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 一级二级缓存
     */
    @Test
    public void testLv1Cache(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            Student student = sqlSession.selectOne("student.queryById", 2);
            Student student2 = sqlSession.selectOne("student.queryById", 2);
            System.out.println(student.hashCode()+":"+student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }

        try {
            sqlSession = MybatisUtils.createSession();
            Student student = sqlSession.selectOne("student.queryById", 2);
            Student student2 = sqlSession.selectOne("student.queryById", 2);
            System.out.println(student.hashCode()+":"+student2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }

    }


    /**
     * 不是用二级缓存 useCache=false
     */
    @Test
    public void testQueryAllNoCache() {

        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            List<Student> list = sqlSession.selectList("student.queryAll");
            List<Student> list2 = sqlSession.selectList("student.queryAll");
            System.out.println(list.hashCode()+":"+list2.hashCode());
//            for (Student s : list) {
//                System.out.println(s);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }

        try {
            sqlSession = MybatisUtils.createSession();
            List<Student> list = sqlSession.selectList("student.queryAll");
            List<Student> list2 = sqlSession.selectList("student.queryAll");
            System.out.println(list.hashCode()+":"+list2.hashCode());
            for (Student s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }


    @Test
    public void testInsertStudentFlush() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
//            Student student = new Student();
            Student student = new Student();
            student.setNickname("测试4");
            student.setRealname("真*测试3");
            student.setMobile("13XXXXXXXXX");
            student.setSex(0);
            student.setCourseId(1);
            student.setBirthday(LocalDate.of(1995, 6, 6));

            //本次成功插入(影响)的总数
            sqlSession.insert("student.insertStudent", student);
            sqlSession.insert("student.insertStudent", student);
            sqlSession.commit();
            System.out.println(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 多对一
     */
    @Test
    public void testManyToOne() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            //本次成功插入(影响)的总数
            List<StudentCourseDTO> list = sqlSession.selectList("student.selectManyToOne");

            for (StudentCourseDTO dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 多对一,主键都是id
     */
    @Test
    public void testManyToOne2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            //本次成功插入(影响)的总数
            List<StudentCourseDTO2> list = sqlSession.selectList("student.selectManyToOne2");

            for (StudentCourseDTO2 dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    /**
     * 多对一,通过select
     */
    @Test
    public void testManyToOne3() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            //本次成功插入(影响)的总数
            List<StudentCourseDTO> list = sqlSession.selectList("student.selectManyToOne3");

            for (StudentCourseDTO dto : list) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testBatchInsertStudent1() {
        SqlSession sqlSession = null;
        try {
            long start = System.currentTimeMillis();
            sqlSession = MybatisUtils.createSession();
            for (int i = 10000; i < 20000; i++) {
                Student student = new Student();
                student.setNickname("测试"+i);
                student.setRealname("真*测试"+i);
                student.setMobile("13XXXXXXXXX");
                student.setSex(0);
                student.setCourseId(1);
                student.setBirthday(LocalDate.of(1995, 6, 6));
                sqlSession.insert("student.insertStudent", student);
            }
            sqlSession.commit();
            long end = System.currentTimeMillis();
            System.out.println("总耗时:"+(end-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testBatchInsertStudent2() {
        SqlSession sqlSession = null;
        try {
            long start = System.currentTimeMillis();
            sqlSession = MybatisUtils.createSession();
            ArrayList<Student> students = new ArrayList<>();
            Student student = null;
            for (int i = 40000; i < 50000; i++) {
                student = new Student();
                student.setNickname("111测试"+i);
                student.setRealname("111真*测试"+i);
                student.setMobile("13XXXXXXXXX");
                student.setSex(0);
                student.setCourseId(1);
                student.setBirthday(LocalDate.of(1995, 6, 6));
                students.add(student);
                student = null;
            }
            sqlSession.insert("student.batchInsertStudent", students);
            sqlSession.commit();
            long end = System.currentTimeMillis();
            System.out.println("总耗时:"+(end-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectPage(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.createSession();
            PageHelper.startPage(2, 10);
            Page<Student> page = (Page)sqlSession.selectList("student.selectPage");
            System.out.println("分页数据"+page.getResult());
            System.out.println("总页数"+page.getPages());
            System.out.println("总记录数"+page.getTotal());
            System.out.println("当前页"+page.getPageNum());
            System.out.println("开始行号"+page.getStartRow());
            System.out.println("结束行号"+page.getEndRow());
            List<Student> list = page.getResult();
            for (Student s : list) {
                System.out.println(s);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            MybatisUtils.closeSession(sqlSession);
        }
    }
}