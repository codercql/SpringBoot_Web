package com.zyg.service.impl;


import com.zyg.dao.DeptMapper;
import com.zyg.pojo.Dept;
import com.zyg.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findAll(Dept dept, int offset, int pageSize) {

        return deptMapper.findAll(dept,offset,pageSize);
    }

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.getDeptList();
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int deleteDept(int id) {
        return deptMapper.deleteDept(id);
    }

    @Override
    public Dept findDeptById(int id) {
        return deptMapper.findDeptById(id);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public int count(Dept dept) {
        return deptMapper.count(dept);
    }
}
