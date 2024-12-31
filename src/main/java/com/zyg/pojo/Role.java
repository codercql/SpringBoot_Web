package com.zyg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_role")
@Data
public class Role {
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;
    private String roleName;
}
