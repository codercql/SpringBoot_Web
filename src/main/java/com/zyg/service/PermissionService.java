package com.zyg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyg.pojo.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {

    List<Permission> getMenuList();

    List<Permission> getMenuListByUserId(Integer loginId);
}
