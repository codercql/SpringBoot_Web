package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.*;
import com.zyg.service.*;
import com.zyg.util.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private BanjiService banjiService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private DormService dormService;

    @Autowired
    private MajorService majorService;
    @RequestMapping("/tolist")
    public String toList(){
        return "student/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Student student, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Student> qw = new QueryWrapper<>();
        if (student.getStudentName() != null && !student.getStudentName().equals("")){
            qw.like("student_name", student.getStudentName());
        }
        long count = studentService.count(qw);
        layData.setCount((int)count);
        IPage<Student> page1 = new Page<>(page, limit);
        List<Student> list = studentService.list(page1, qw);
        list.stream().map(student1 ->{
           //查询年级
            Grade grade = gradeService.getOne(new LambdaQueryWrapper<Grade>().eq(Grade::getGradeId, student1.getGradeId()));
            student1.setGrade(grade);
            //查询班级
            Banji banji = banjiService.getOne(new LambdaQueryWrapper<Banji>().eq(Banji::getBanjiId, student1.getBanjiId()));
            student1.setBanji(banji);
            //查询专业
            Major major = majorService.getOne(new LambdaQueryWrapper<Major>().eq(Major::getMajorId, student1.getMajorId()));
            student1.setMajor(major);
            //查询宿舍
            Dorm dorm = dormService.getOne(new LambdaQueryWrapper<Dorm>().eq(Dorm::getDormId, student1.getDormId()));
            student1.setDorm(dorm);
            return student1;
        }).collect(Collectors.toList());
        layData.setData(list);

        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "student/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Student student){
        boolean flag = studentService.save(student);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Student student){
        boolean flag = studentService.updateById(student);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable("id") Integer id){
        boolean flag = studentService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }
}
