package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Dorm;
import com.zyg.service.DormService;
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
@RequestMapping("/dorm")
public class DormController {

    @Autowired
    private DormService dormService;

    @RequestMapping("/tolist")
    public String tolist(){
        return "dorm/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Dorm dorm, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Dorm> qw = new QueryWrapper<>();
        if (dorm.getDormName() != null && !dorm.getDormName().equals("")){
            qw.like("dorm_name", dorm.getDormName());
        }
        long count = dormService.count(qw);
        layData.setCount((int)count);
        IPage<Dorm> page1 = new Page<>(page, limit);
        List<Dorm> list = dormService.list(page1, qw);
        layData.setData(list);

        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "dorm/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Dorm dorm){
        boolean flag = dormService.save(dorm);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Dorm dorm = dormService.getById(id);
        model.addAttribute("dorm", dorm);
        return "dorm/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Dorm dorm){
        boolean flag = dormService.updateById(dorm);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteDorm(@PathVariable("id") Integer id){
        boolean flag = dormService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }

}
