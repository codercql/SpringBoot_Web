package com.zyg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyg.pojo.Dorm;

import java.util.List;

public interface DormService extends IService<Dorm> {
    List<Dorm> getDormList();
}
