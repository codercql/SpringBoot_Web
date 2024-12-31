package com.zyg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper extends BaseMapper<Major> {
    List<Major> getMajorList();
}
