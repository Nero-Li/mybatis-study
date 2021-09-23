package com.softeem.dto;

import com.softeem.entity.Student;

import java.time.LocalDate;

/**
 * description:
 * DTO:数据传输对象 Data Transfer Object
 * @author lyming
 * @date 2020/12/24 4:28 下午
 */
public class StudentDTO2 {

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
//    private Date birthday;
    private LocalDate birthday;
    /**
     * 所属班级
     */
    private Integer courseId;

    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "StudentDTO2{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", birthday=" + birthday +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
