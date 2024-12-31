package com.zyg.dao;

import com.zyg.pojo.Dept;
import com.zyg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {

    List<Dept> findAll(@Param("dept") Dept dept,  @Param("offset") int offset,  @Param("pageSize") int pageSize);

    int addDept(Dept dept);

    int deleteDept(int id);

    Dept findDeptById(int id);

    int updateDept(Dept dept);

    int count(Dept dept);

    List<Dept> getDeptList();
}
