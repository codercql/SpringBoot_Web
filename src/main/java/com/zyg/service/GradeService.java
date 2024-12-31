package com.zyg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyg.pojo.Grade;

import java.util.List;

public interface GradeService extends IService<Grade> {
    List<Grade> getGradeList();

}
