package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Permission;
import com.zyg.service.PermissionService;
import com.zyg.util.LayData;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {


    @Resource
    private PermissionService permissionService;

    @RequestMapping("/tolist")
    public  String tolist(){
        return "permission/list";
    }


    @RequestMapping("/list")
    @ResponseBody
    public  String list(Permission permission, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Permission> qw = new QueryWrapper<>();
        qw.like(permission.getMenuName() != null && !"".equals(permission.getMenuName()),"menu_name",permission.getMenuName());
        long totalCount = permissionService.count(qw);
        layData.setCount((int) totalCount);
        Page<Permission> page1 = new Page<>(page, limit);
        layData.setData(permissionService.list(page1, qw));
        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);
        return data;
    }


    @RequestMapping("/totreelist")
    public  String totreelist(){
        return "permission/treelist";
    }
    @RequestMapping("/treelist")
    @ResponseBody
    public  String treelist(Permission permission, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Permission> qw = new QueryWrapper<>();
        long totalCount = permissionService.count(qw);
        layData.setCount((int) totalCount);
        layData.setData(permissionService.list());
        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);
        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "permission/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Permission permission){
        boolean result = permissionService.save(permission);
        if (result) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Permission permission = permissionService.getById(id);
        model.addAttribute("permission", permission);
        return "permission/update";
    }

    @RequestMapping("/toinfo/{id}")
    public String toInfo(@PathVariable("id") int id, Model model){
        Permission permission = permissionService.getById(id);
        model.addAttribute("permission", permission);
        return "permission/info";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Permission permission){
        boolean result = permissionService.updateById(permission);
        if (result) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteRole(@PathVariable("id") int id){
        boolean result = permissionService.removeById(id);
        if (result) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }
    }

    @RequestMapping("/listMenu")
    @ResponseBody
    public String listMenu(@RequestParam("menuType") String menuType){
        QueryWrapper<Permission> qw = new QueryWrapper<>();
        qw.eq("menu_type",menuType);
        List<Permission> list = permissionService.list(qw);
        return JSON.toJSONString(list);
    }
}
