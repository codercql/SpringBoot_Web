package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Grade;
import com.zyg.service.GradeService;
import com.zyg.util.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/tolist")
    public String tolist(){
        return "grade/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Grade grade, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Grade> qw = new QueryWrapper<>();
        if (grade.getGradeName() != null && !grade.getGradeName().equals("")){
            qw.like("grade_name", grade.getGradeName());
        }
        long count = gradeService.count(qw);
        layData.setCount((int)count);
        IPage<Grade> page1 = new Page<>(page, limit);
        List<Grade> list = gradeService.list(page1, qw);
        layData.setData(list);

        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "grade/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Grade grade){
        boolean flag = gradeService.save(grade);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Grade grade = gradeService.getById(id);
        model.addAttribute("grade", grade);
        return "grade/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Grade grade){
        boolean flag = gradeService.updateById(grade);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteGrade(@PathVariable("id") Integer id){
        boolean flag = gradeService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }

}
