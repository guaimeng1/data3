package com.tt.data3.service.impl;

import com.tt.data3.dao.StudentDao;
import com.tt.data3.dao.StudentDao2;
import com.tt.data3.pojo.Grade;
import com.tt.data3.pojo.Student;
import com.tt.data3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;
    @Autowired
    @Qualifier("studentDao2")
    private StudentDao2 studentDao2;
    //添加年级信息的方法
    @Transactional
    public void addGrade(Grade grade) {
        studentDao.save(grade);
    }

    //删除
    @Transactional
    public void deleteGrade(Integer gradeId) {
        studentDao.deleteById(gradeId);
    }

    //查询
    public List<Grade> findGrade() {
        return (List<Grade>) studentDao.findAll();
    }

    //查询信息的数量
    public int getCount() {
        return (int) studentDao.count();
    }

    //根据ID查询
    public Optional<Grade> findGradeById(Integer gradeId) {
        return studentDao.findById(gradeId);
    }

    //排序
    public List<Grade> findGradeSort(Sort sort) {
        return (List<Grade>) studentDao.findAll(sort);
    }

    //分页
    public Page<Grade> findGradePage(Pageable pageable) {
        return studentDao.findAll(pageable);
    }

    @Override
    public List<Student> getStuByName(String studentName) {
        return studentDao2.findStudentByStudentName(studentName);
    }

    @Override
    public List<Student> getStuByPwd(String loginPwd) {
        return studentDao2.findStudentByLoginPwd(loginPwd);
    }

    @Override
    public List<Student> getStuByNoPwd(Integer studentNo, String loginPwd) {
        return studentDao2.findStudentByStudentNoAndLoginPwd(studentNo,loginPwd);
    }

    @Override
    public List<Student> getStuByNameLike(String studentName) {
        return studentDao2.findStudentByStudentNameLike("%"+studentName+"%");
    }

    @Override
    public List<Student> getStuByNameLikeSort(String studentName) {
        return studentDao2.findStudentByStudentNameLikeOrderByStudentNoDesc("%"+studentName+"%");
    }
}
