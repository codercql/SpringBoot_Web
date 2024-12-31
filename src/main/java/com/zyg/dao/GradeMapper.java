package com.zyg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {

    List<Grade> getGradeList();
}
