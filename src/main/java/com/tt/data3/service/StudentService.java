package com.tt.data3.service;

import com.tt.data3.pojo.Grade;
import com.tt.data3.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    //添加学生信息的方法
    void addGrade(Grade grade);
    //删除
    void deleteGrade(Integer gradeId);
    //查询
    List<Grade> findGrade();
    //查询信息的数量
    int getCount();
    //根据ID查询
    Optional<Grade> findGradeById(Integer gradeId);
    //排序
    List<Grade> findGradeSort(Sort sort);
    //分页
    Page<Grade> findGradePage(Pageable pageable);

    List<Student> getStuByName(String studentName);

    List<Student> getStuByPwd(String loginPwd);

    List<Student> getStuByNoPwd(Integer studentNo, String loginPwd);

    List<Student> getStuByNameLike(String studentName);

    List<Student> getStuByNameLikeSort(String studentName);
}
