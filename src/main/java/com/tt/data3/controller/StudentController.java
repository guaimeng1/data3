package com.tt.data3.controller;

import com.tt.data3.pojo.Grade;
import com.tt.data3.pojo.Student;
import com.tt.data3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
 * #作者：zhangshuai
 * #时间：2018/11/22 8:09
 * #描述：学生的控制器：负责学生相关的增删改查
*/
@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;
    //添加年级信息的方法
    @RequestMapping("/addGrade")
    public String addGrade() {
        Grade grade=new Grade();
        grade.setGradeName("第si学期");
        studentService.addGrade(grade);
        return "ok";
    }
    //删除
    @RequestMapping("/deleteGrade")
    public String deleteGrade(@RequestParam Integer gradeId) {
        studentService.deleteGrade(gradeId);
        return "ok";
    }
    //查询
    @RequestMapping("/findGrade")
    @ResponseBody
    public Object findGrade() {
        List<Grade> list=studentService.findGrade();
        return list;
    }
    //查询信息的数量
    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount() {
        int count=studentService.getCount();
        return count;
    }
    //根据ID查询
    @RequestMapping("/findGradeById")
    @ResponseBody
    public Object findGradeById(@RequestParam Integer gradeId) {
        Optional<Grade> grade=studentService.findGradeById(gradeId);
        return grade;
    }
    //排序
    @RequestMapping("/findGradeSort")
    @ResponseBody
    public Object findGradeSort() {
        Sort sort=new Sort(Sort.Direction.ASC,"gradeID");
        List<Grade> list=studentService.findGradeSort(sort);
        return list;
    }
    //分页
    @RequestMapping("/findGradePage")
    @ResponseBody
    public Object findGradePage(@RequestParam Integer pageIndex) {
        Pageable pageable= PageRequest.of(pageIndex-1,2);
        Page<Grade> page=studentService.findGradePage(pageable);
        System.out.println("查询总页数"+page.getTotalPages());
        System.out.println("查询总条数"+page.getTotalElements());
        System.out.println("当前是第几页"+(page.getNumber()+1));
        //getContent表示：获取当前页的数据
        List<Grade> list=page.getContent();
        return page;
    }
    //根据学生姓名查询学生信息
    @RequestMapping("/getStuByName")
    @ResponseBody
    public Object getStuByName(@RequestParam String studentName) {
        List<Student> list=studentService.getStuByName(studentName);
        return list;
    }
    //根据学生密码查询学生信息
    @RequestMapping("/getStuByPwd")
    @ResponseBody
    public Object getStuByPwd(@RequestParam String loginPwd) {
        List<Student> list=studentService.getStuByPwd(loginPwd);
        return list;
    }
    //根据学号和密码查询学生信息
    @RequestMapping("/getStuByNoPwd")
    @ResponseBody
    public Object getStuByNoPwd(@RequestParam Integer studentNo,@RequestParam String loginPwd) {
        List<Student> list=studentService.getStuByNoPwd(studentNo,loginPwd);
        return list;
    }
    //根据学生姓名模糊查询学生信息
    @RequestMapping("/getStuByNameLike")
    @ResponseBody
    public Object getStuByNameLike(@RequestParam String studentName) {
        List<Student> list=studentService.getStuByNameLike(studentName);
        return list;
    }
    //根据学生姓名模糊，并根据学号进行降序查询学生信息
    @RequestMapping("/getStuByNameLikeSort")
    @ResponseBody
    public Object getStuByNameLikeSort(@RequestParam String studentName) {
        List<Student> list=studentService.getStuByNameLikeSort(studentName);
        return list;
    }
}
