package com.zyg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_dorm")
public class Dorm {
    @TableId(value = "dorm_id",type = IdType.AUTO)
    private Integer dormId;
    private String dormName;
}
