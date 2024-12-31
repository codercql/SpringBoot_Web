package com.zyg.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyg.dao.BanjiMapper;
import com.zyg.pojo.Banji;
import com.zyg.service.BanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("banjiService")
  public class BanjiServiceImpl extends ServiceImpl<BanjiMapper, Banji> implements BanjiService {
    @Autowired
    private BanjiMapper banjiMapper;
    @Override
    public List<Banji> findAll(Banji banji, int offset, int pageSize) {
        return banjiMapper.findAll(banji.getBanjiName(), offset, pageSize);
    }

    @Override
    public Banji findBanjiById(Integer id) {
        return banjiMapper.findBanjiById(id);
    }

    @Override
    public List<Banji> getBanjiList() {
      return banjiMapper.getBanjiList();
    }

}
