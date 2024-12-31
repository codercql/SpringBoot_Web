package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.pojo.Role;
import com.zyg.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/tolist")
    public String tolist(){
        return "role/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(Role role, @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        QueryWrapper<Role> qw = new QueryWrapper<>();
        if (role.getRoleName() != null && !role.getRoleName().equals("")){
            qw.like("role_name", role.getRoleName());
        }
        long count = roleService.count(qw);
        layData.setCount((int)count);
        IPage<Role> page1 = new Page<>(page, limit);
        List<Role> list = roleService.list(page1, qw);
        layData.setData(list);

        layData.setCode(0);
        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "role/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(Role role){
        boolean flag = roleService.save(role);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "role/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(Role role){
        boolean flag = roleService.updateById(role);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteRole(@PathVariable("id") Integer id){
        boolean flag = roleService.removeById(id);
        if (flag) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }

    }

}
