package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Major;
import com.zyg.service.MajorService;
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
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @RequestMapping("/tolist")
    public String tolist(){
        return "major/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Major major, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Major> qw = new QueryWrapper<>();
        if (major.getMajorName() != null && !major.getMajorName().equals("")){
            qw.like("major_name", major.getMajorName());
        }
        long count = majorService.count(qw);
        layData.setCount((int)count);
        IPage<Major> page1 = new Page<>(page, limit);
        List<Major> list = majorService.list(page1, qw);
        layData.setData(list);

        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "major/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Major major){
        boolean flag = majorService.save(major);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Major major = majorService.getById(id);
        model.addAttribute("major", major);
        return "major/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Major major){
        boolean flag = majorService.updateById(major);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteMajor(@PathVariable("id") Integer id){
        boolean flag = majorService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }
}
