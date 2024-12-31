package com.zyg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyg.pojo.Major;

import java.util.List;

public interface MajorService extends IService<Major> {
    List<Major> getMajorList();
}
