package com.zyg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_permission")
public class Permission {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String menuName;
    private String menuType;
    private Integer parentId;
    private String url;
    private String perms;

    // 此属性用来构建树形结构
    @TableField(exist = false)
    List<Permission> children;

    @TableField(exist = false)
    Boolean isParent = false;
}