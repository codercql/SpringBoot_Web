package com.zyg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.pojo.Banji;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BanjiMapper extends BaseMapper<Banji> {
    public List<Banji> findAll(@Param("banjiName")String banjiName, int offset, int pageSize);
    public Banji findBanjiById(Integer id);

    List<Banji> getBanjiList();
}
