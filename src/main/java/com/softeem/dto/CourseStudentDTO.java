package com.softeem.dto;

import com.softeem.entity.Student;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author lyming
 * @date 2020/12/30 3:34 下午
 */
public class CourseStudentDTO implements Serializable {

    private static final long serialVersionUID = -2875503182963548638L;

    /**
     * 主键ID
     */
    private Integer courseId;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 课程内容
     */
    private String courseContext;
    /**
     * 课程开始时间
     */
    private Date beginTime;
    /**
     * 课程结束时间
     */
    private Date endTime;

    private List<Student> studentList;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseContext() {
        return courseContext;
    }

    public void setCourseContext(String courseContext) {
        this.courseContext = courseContext;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "CourseStudentDTO{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseContext='" + courseContext + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", studentList=" + studentList +
                '}';
    }
}
