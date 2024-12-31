package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Banji;
import com.zyg.service.BanjiService;
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
@RequestMapping("/banji")
public class BanjiController {

    @Autowired
    private BanjiService banjiService;

    @RequestMapping("/tolist")
    public String tolist(){
        return "banji/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Banji banji, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        List<Banji> banjiList = banjiService.findAll(banji, (page - 1) * limit, limit);
        layData.setData(banjiList);
        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "banji/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Banji banji){
        boolean flag = banjiService.save(banji);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Banji banji = banjiService.findBanjiById(id);
        model.addAttribute("banji", banji);
        return "banji/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Banji banji){
        boolean flag = banjiService.updateById(banji);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBanji(@PathVariable("id") Integer id){
        boolean flag = banjiService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }

    @RequestMapping("/toinfo/{id}")
    public String toinfo(@PathVariable("id") Integer id, Model model){
        Banji banji = banjiService.findBanjiById(id);
        model.addAttribute("banji", banji);
        return "banji/info";
    }

}
