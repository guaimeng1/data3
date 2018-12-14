package com.tt.data3.dao;

import com.tt.data3.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao2 extends JpaRepository<Student,Integer>{

    List<Student> findStudentByStudentName(String studentName);

    List<Student> findStudentByLoginPwd(String loginPwd);

    List<Student> findStudentByStudentNoAndLoginPwd(Integer studentNo, String loginPwd);

    List<Student> findStudentByStudentNameLike(String studentName);

    List<Student> findStudentByStudentNameLikeOrderByStudentNoDesc(String studentName);
}
