package com.zyg.service;

import com.zyg.pojo.MajorBoyGirlNumVO;
import com.zyg.pojo.NameValueVO;
import com.zyg.pojo.Permission;
import com.zyg.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll(User condition, int offset, int pageSize);

    int addUser(User user);

    int deleteUser(int id);

    User findUserById(int id);

    int updateUser(User user);

    int count(User condition);

    User login(User user);

    User findUserByUserName(String username);

    List<Permission> getMenuList();

    List<Permission> getMenuListByUserId(Integer loginId);

    List<NameValueVO> getStudentRatio();

    List<NameValueVO> majorStudentNum();

    List<NameValueVO> majorStudentRatio();

    List<NameValueVO> gradeStudentNum();
    List<NameValueVO> banjiStudentNum();
    List<MajorBoyGirlNumVO> majorBoyGirlNum();
}
