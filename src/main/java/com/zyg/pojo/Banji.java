package com.zyg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_banji")
@Data
public class Banji {
    @TableId(value = "banji_id",type = IdType.AUTO)
    private Integer banjiId;
    private String banjiName; //

    private Long gradeId;
    @TableField(exist = false)
    private Grade grade;
}
