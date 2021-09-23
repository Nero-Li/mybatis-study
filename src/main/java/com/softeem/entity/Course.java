package com.softeem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程(Course)实体类
 *
 * @author makejava
 * @since 2020-12-24 15:21:06
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 182913687033374483L;
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

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseContext='" + courseContext + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}