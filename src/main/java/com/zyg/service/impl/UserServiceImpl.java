package com.zyg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyg.dao.UserMapper;
import com.zyg.pojo.*;
import com.zyg.service.PermissionService;
import com.zyg.service.UserRoleService;
import com.zyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public List<User> findAll(User user, int offset, int pageSize) {

        return userMapper.findAll(user,offset,pageSize);
    }

    @Override
    public int addUser(User user) {
        // 先新增用户
        int result = userMapper.addUser(user);
        // 获取新增用户的主键
        int userId = user.getId();

        // 往user_role 插入数据
        Integer[] roleIds = user.getRoleIds();
        List<UserRole> userRoleList = new ArrayList<>();
        if (roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUId(userId);
                userRole.setRId(roleId);
                userRoleList.add(userRole);
            }
            userRoleService.saveBatch(userRoleList);
        }
        return result;
    }

    @Override
    public int deleteUser(int id) {
        // 删除用户及用户所关联的角色
        // todo
        return userMapper.deleteUser(id);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    @Transactional
    public int updateUser(User user) {
        // 先更新用户
        int result = userMapper.updateUser(user);
        // 删除用户对应的角色
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",user.getId());
        userRoleService.remove(queryWrapper);

        // 新增用户角色
        // 往user_role 插入数据
        Integer[] roleIds = user.getRoleIds();
        List<UserRole> userRoleList = new ArrayList<>();
        if (roleIds != null && roleIds.length > 0) {
            for (Integer roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUId(user.getId());
                userRole.setRId(roleId);
                userRoleList.add(userRole);
            }
            userRoleService.saveBatch(userRoleList);
        }
        return result;
    }

    @Override
    public int count(User user) {
        return userMapper.count(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }



    @Override
    public List<Permission> getMenuList() {
        List<Permission> menuList = permissionService.getMenuList();
        return menuList;
    }

    @Override
    public List<Permission> getMenuListByUserId(Integer loginId) {
        List<Permission> menuList = permissionService.getMenuListByUserId(loginId);
        return menuList;
    }

    @Override
    public List<NameValueVO> getStudentRatio() {
        List<NameValueVO> nameValueVOS = new ArrayList<>();
        nameValueVOS.add(new NameValueVO("boy",userMapper.getBoyRatio()));
        nameValueVOS.add(new NameValueVO("girl",userMapper.getGirlRatio()));
        return nameValueVOS;
    }

    @Override
    public List<NameValueVO> majorStudentNum() {
        return userMapper.majorStudentNum();
    }

    @Override
    public List<NameValueVO> majorStudentRatio() {
        return userMapper.majorStudentRatio();
    }

    @Override
    public List<NameValueVO> gradeStudentNum() {
        return userMapper.gradeStudentNum();
    }

    @Override
    public List<NameValueVO> banjiStudentNum() {
        return userMapper.banjiStudentNum();
    }

    @Override
    public List<MajorBoyGirlNumVO> majorBoyGirlNum() {
        return userMapper.majorBoyGirlNum();
    }


}
