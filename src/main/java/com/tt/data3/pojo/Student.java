package com.tt.data3.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #作者：zhangshuai
 * #时间：2018/11/22 8:12
 * #描述：student学生类
*/
@Entity
@Table(name = "students")
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentNo;
    private String loginPwd;
    private String studentName;

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student() {
    }

    public Student(Integer studentNo, String loginPwd, String studentName) {
        this.studentNo = studentNo;
        this.loginPwd = loginPwd;
        this.studentName = studentName;
    }
}
