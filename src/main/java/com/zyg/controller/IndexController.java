package com.zyg.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.zyg.pojo.Permission;
import com.zyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    @RequestMapping("/toindex")
    public String index(Model model){
        Integer loginId = StpUtil.getLoginIdAsInt();
        List<Permission> menuList = new ArrayList<>();
        if (loginId != null && loginId == 1) {

            menuList = userService.getMenuList();
        } else {

            menuList = userService.getMenuListByUserId(loginId);
        }
        model.addAttribute("menuList",menuList);
        return "index";
    }



    @RequestMapping("/index_v1")
    public String index_v1(){
        return "index_v1";
    }
}
