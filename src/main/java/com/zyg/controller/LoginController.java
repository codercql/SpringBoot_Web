package com.zyg.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.alibaba.fastjson2.JSON;
import com.zyg.pojo.User;
import com.zyg.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping()
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, String code, HttpSession session){
        // 校验验证码
        String sessionCode = (String) session.getAttribute("code");

        if (!sessionCode.equalsIgnoreCase(code)){
            return "redirect:/";
        }
        User u = userService.login(user);
        if(u != null){
            //保存用户凭证
            StpUtil.login(u.getId());
            return "redirect:/toindex";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/code")
    @ResponseBody
    public String code(HttpSession session){
        //删掉之前的验证码
        session.removeAttribute("code");
        //调用hutool 生成验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200,100);
        String code = lineCaptcha.getCode();
        session.setAttribute("code",code);
        System.out.println(code);
        //转换json格式 fastjson2
    	return JSON.toJSONString(lineCaptcha.getImageBase64());
    }
}
