package com.zyg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyg.dao.DormMapper;
import com.zyg.pojo.Dorm;
import com.zyg.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dormService")
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {

    @Autowired
    private DormMapper dormMapper;

    @Override
    public List<Dorm> getDormList() {
        return dormMapper.getDormList();
    }
}
