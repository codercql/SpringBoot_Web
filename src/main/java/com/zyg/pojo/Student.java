package com.zyg.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_student")
public class Student {
    @TableId(value = "student_id",type = IdType.AUTO)
    private Integer studentId;
    private String studentName;
    private String studentPassword;
    private String studentGender;
    private Integer studentAge;

    private Long banjiId;
    private Long gradeId;
    private Long dormId;
    private Long majorId;
    @TableField(exist = false)
    private Banji banji;
    @TableField(exist = false)
    private Grade grade;
    @TableField(exist = false)
    private Dorm dorm;
    @TableField(exist = false)
    private Major major;
}
