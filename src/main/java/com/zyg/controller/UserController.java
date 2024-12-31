package com.zyg.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyg.pojo.MajorBoyGirlNumVO;
import com.zyg.pojo.NameValueVO;
import com.zyg.pojo.User;
import com.zyg.pojo.UserRole;
import com.zyg.service.UserRoleService;
import com.zyg.service.UserService;
import com.zyg.util.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/tolist")
    public  String tolist(){
        return "user/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public  String list(User user, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        // 查询数据
        LayData layData = new LayData();
        int totalCount = userService.count(user);
        layData.setCount(totalCount);

        layData.setData(userService.findAll(user, (page - 1) * limit, limit));

        layData.setCode(0);

        layData.setMsg("查询成功");
        // 数据返回
        String data = JSON.toJSONString(layData);

        return data;
    }

    @RequestMapping("/toadd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public String addSave(User user){
        int result = userService.addUser(user);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "添加成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "添加失败"));
        }
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        User user = userService.findUserById(id);

        // 查询当前用户具有哪些角色
        QueryWrapper<UserRole> qw = new QueryWrapper();
        qw.eq("u_id", user.getId());
        List<UserRole> userRoleList = userRoleService.list(qw);

        // 对集合 作二次处理
        List<Integer> roleIds = userRoleList.stream().map(UserRole::getRId).toList();
        model.addAttribute("user", user);
        model.addAttribute("roleIds", roleIds);
        return "user/update";
    }

    @RequestMapping("/updateSave")
    @ResponseBody
    public String updateSave(User user){
        int result = userService.updateUser(user);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "更新成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "更新失败"));
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id){
        int result = userService.deleteUser(id);
        if (result > 0) {
            return JSON.toJSONString(new LayData(0, "删除成功"));
        } else {
            return JSON.toJSONString(new LayData(500, "删除失败"));
        }
    }

    /**
     * 学生性别百分比
     * boy:x
     * girl:x
     * @return
     */
    @GetMapping("/gender/ratio")
    @ResponseBody
    public List<NameValueVO> getStudentRatio(){
        return userService.getStudentRatio();
    }


    /**
     * 各专业学生人数排名，列表按人数多->少的顺序
     * @return
     */
    @GetMapping("/major/student/num")
    @ResponseBody
    public List<NameValueVO> majorStudentNum(){
        return userService.majorStudentNum();
    }


    /**
     * 各专业人数比例
     * @return
     */
    @GetMapping("/major/student/ratio")
    @ResponseBody
    public List<NameValueVO> majorStudentRatio(){
        return userService.majorStudentRatio();
    }

    /**
     * 各年级学生人数统计
     * @return
     */
    @GetMapping("/grade/student/num")
    @ResponseBody
    public List<NameValueVO> gradeStudentNum(){
        return userService.gradeStudentNum();
    }

    /**
     * 班级各学生人数前6位
     * @return
     */
    @GetMapping("/banji/student/num")
    @ResponseBody
    public List<NameValueVO> banjiStudentNum(){
        return userService.banjiStudentNum();
    }

    /**
     * 各专业男女生数量
     * @return
     */
    @GetMapping("/major/boy/girl/num")
    @ResponseBody
    public List<MajorBoyGirlNumVO> majorBoyGirlNum(){
        return userService.majorBoyGirlNum();
    }






}
