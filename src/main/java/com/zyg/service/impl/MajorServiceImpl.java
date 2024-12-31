package com.zyg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyg.dao.MajorMapper;
import com.zyg.pojo.Major;
import com.zyg.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("majorService")
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> getMajorList() {
        return majorMapper.getMajorList();
    }
}
