package com.softeem.dto;

import com.softeem.entity.Course;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * description:
 *
 * @author lyming
 * @date 2020/12/30 3:28 下午
 */
public class StudentCourseDTO implements Serializable {

    private static final long serialVersionUID = 1775422358726216621L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 性别 性别 1:男  0:女  2:保密
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 所属班级id
     */
    private Integer courseId;

    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentCourseDTO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", birthday=" + birthday +
                ", courseId=" + courseId +
                ", course=" + course +
                '}';
    }
}
