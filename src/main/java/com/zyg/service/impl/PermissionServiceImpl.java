package com.zyg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyg.dao.PermissionMapper;
import com.zyg.pojo.Permission;
import com.zyg.pojo.RolePermission;
import com.zyg.pojo.UserRole;
import com.zyg.service.PermissionService;
import com.zyg.service.RolePermissionService;
import com.zyg.service.RoleService;
import com.zyg.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Permission> list() {

        List<Permission> permissions = baseMapper.selectList(null);
        // 创建根集合
        List<Permission> root = permissions.stream().filter(p -> p.getParentId() == 0).toList();
        // 递归给根集合设置子节点
        root.forEach(p -> {
            p.setChildren(getChildren(p.getId(), permissions));
            p.setIsParent(p.getChildren().size() > 0);
        });
        return root;
    }

    private List<Permission> getChildren(Integer id, List<Permission> permissions) {
        List<Permission> children = new ArrayList<>();
        permissions.forEach(p -> {
            if (p.getParentId() != null && p.getParentId().equals(id)) {
                p.setChildren(getChildren(p.getId(), permissions));
                p.setIsParent(p.getChildren().size() > 0);
                children.add(p);
            }
        });
        return children;
    }
    @Override
    public List<Permission> getMenuList() {
        List<Permission> permissions = baseMapper.selectList(null);
        List<Permission> permissionList = permissions.stream().filter(p -> !p.getMenuType().equals("F")).toList();

        // 创建根集合
        List<Permission> root = permissionList.stream().filter(p -> p.getParentId() == 0).toList();
        // 递归给根集合设置子节点
        root.forEach(p -> {
            p.setChildren(getChildren(p.getId(), permissions));
            p.setIsParent(p.getChildren().size() > 0);
        });
        return root;
    }

    @Override
    public List<Permission> getMenuListByUserId(Integer loginId) {
        // 获取日志记录器实例，用于记录调试信息和警告
        Logger logger = LoggerFactory.getLogger(this.getClass());

        // 创建查询条件，根据用户ID查询用户角色
        QueryWrapper<UserRole> userRoleQw = new QueryWrapper<>();
        userRoleQw.eq("u_id", loginId);

        // 查询用户的角色列表
        List<UserRole> userRoleList = userRoleService.list(userRoleQw);

        // 如果没有找到任何角色，记录警告并返回空列表
        if (userRoleList == null || userRoleList.isEmpty()) {
            logger.warn("No roles found for user with id: {}", loginId);
            return Collections.emptyList();
        }

        // 提取用户角色的ID列表
        List<Integer> roleIds = userRoleList.stream().map(UserRole::getRId).toList();

        // 创建查询条件，根据角色ID查询角色权限
        QueryWrapper<RolePermission> rolePermissionQw = new QueryWrapper<>();
        rolePermissionQw.in("r_id", roleIds);

        // 查询角色权限列表
        List<RolePermission> rolePermissionList = rolePermissionService.list(rolePermissionQw);

        // 如果没有找到任何权限，记录警告并返回空列表
        if (rolePermissionList == null || rolePermissionList.isEmpty()) {
            logger.warn("No permissions found for roles: {}", roleIds);
            return Collections.emptyList();
        }

        // 提取权限的ID列表
        List<Integer> permissionIds = rolePermissionList.stream().map(RolePermission::getPId).toList();

        // 根据权限ID列表查询具体的权限信息
        List<Permission> permissions = listByIds(permissionIds);

        // 如果没有找到任何权限详情，记录警告并返回空列表
        if (permissions == null || permissions.isEmpty()) {
            logger.warn("No permission details found for ids: {}", permissionIds);
            return Collections.emptyList();
        }

        // 过滤掉菜单类型为 "F" 的权限（假设 "F" 表示功能而非菜单）
        List<Permission> permissionList = permissions.stream()
                .filter(p -> !p.getMenuType().equals("F"))
                .toList();

        // 筛选出根节点（父节点ID为0）的权限，并设置子节点
        List<Permission> root = permissionList.stream()
                .filter(p -> p.getParentId() == 0)
                .peek(p -> {
                    // 递归获取当前权限的子节点
                    List<Permission> children = getChildren(p.getId(), permissions);
                    p.setChildren(children);
                    // 设置是否为父节点标志
                    p.setIsParent(!children.isEmpty());
                })
                .toList();

        // 返回根节点权限列表
        return root;
    }
}
