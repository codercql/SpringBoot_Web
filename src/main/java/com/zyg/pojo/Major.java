package com.zyg.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_major")
public class Major {
    @TableId(value = "major_id",type = IdType.AUTO)
    private Integer majorId;
    private String majorName;
}
