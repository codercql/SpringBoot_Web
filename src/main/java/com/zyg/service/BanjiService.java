package com.zyg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyg.pojo.Banji;
import com.zyg.pojo.Dept;

import java.util.List;

public interface BanjiService extends IService<Banji> {

    public List<Banji> findAll(Banji banji, int offset, int pageSize);

    public Banji findBanjiById(Integer id);

    List<Banji> getBanjiList();

}
