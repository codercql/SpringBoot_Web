package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.zyg.pojo.Dept;
import com.zyg.service.DeptService;
import com.zyg.util.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/tolist")
    public  String tolist(){
        return "dept/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Dept dept, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        int totalCount = deptService.count(dept);
        layData.setCount(totalCount);

        layData.setData(deptService.findAll(dept, (page - 1) * limit, limit));

        layData.setCode(0);

        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "dept/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Dept dept){
        int result = deptService.addDept(dept);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Dept dept = deptService.findDeptById(id);
        model.addAttribute("dept", dept);
        return "dept/update";
    }

    @RequestMapping("/toinfo/{id}")
    public String toInfo(@PathVariable("id") int id, Model model){
        Dept dept = deptService.findDeptById(id);
        model.addAttribute("dept", dept);
        return "dept/info";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Dept dept){
        int result = deptService.updateDept(dept);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDept(@PathVariable("id") int id){
        int result = deptService.deleteDept(id);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }
    }

}
