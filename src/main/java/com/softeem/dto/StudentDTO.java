package com.softeem.dto;

import com.softeem.entity.Student;

/**
 * description:
 * DTO:数据传输对象 Data Transfer Object
 * @author lyming
 * @date 2020/12/24 4:28 下午
 */
public class StudentDTO {

    private Student student = new Student();

    private String courseName;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student=" + student +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
