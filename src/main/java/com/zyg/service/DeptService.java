package com.zyg.service;

import com.zyg.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll(Dept condition, int offset, int pageSize);
    List<Dept> getDeptList();

    int addDept(Dept dept);

    int deleteDept(int id);

    Dept findDeptById(int id);

    int updateDept(Dept dept);

    int count(Dept condition);
}
