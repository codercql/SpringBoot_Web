package com.zyg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_grade")
@Data
public class Grade {
    @TableId(value = "grade_id",type = IdType.AUTO)
    private Integer gradeId;
    private String gradeName;
}
