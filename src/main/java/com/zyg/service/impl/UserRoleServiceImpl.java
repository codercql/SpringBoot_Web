package com.zyg.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyg.dao.UserRoleMapper;
import com.zyg.pojo.UserRole;
import com.zyg.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
