package com.tt.data3.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * #作者：zhangshuai
 * #时间：2018/11/22 8:19
 * #描述：grade年级表
*/
@Entity
@Table(name = "grades")
public class Grade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeID;
    private String  gradeName;

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }
}
