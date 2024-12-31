package com.zyg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.pojo.Dorm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormMapper extends BaseMapper<Dorm> {
    List<Dorm> getDormList();
}
