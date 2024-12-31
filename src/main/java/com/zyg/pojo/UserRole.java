package com.zyg.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
@TableName("user_role")
public class UserRole {
    private Integer uId;
    private Integer rId;
}
