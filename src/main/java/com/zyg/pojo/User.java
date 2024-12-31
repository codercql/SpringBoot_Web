package com.zyg.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private String pass;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Dept dept;

    private Long deptId;

    //角色列表
    private List<Role> roleList;

    //角色编号数组
    private Integer[] roleIds;
}
