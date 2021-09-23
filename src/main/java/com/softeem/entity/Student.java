package com.softeem.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * 学生
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-12-24 15:21:07
 */

public class Student implements Serializable {

    private static final long serialVersionUID = -46814921864560341L;
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

//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", birthday=" + birthday +
                ", courseId=" + courseId +
                '}';
    }
}