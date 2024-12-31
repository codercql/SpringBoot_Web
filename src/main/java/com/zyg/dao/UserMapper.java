package com.zyg.dao;

import com.zyg.pojo.MajorBoyGirlNumVO;
import com.zyg.pojo.NameValueVO;
import com.zyg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.thymeleaf.spring6.processor.SpringInputGeneralFieldTagProcessor;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll(@Param("user") User user, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int addUser(User user);

    int deleteUser(int id);

    User findUserById(int id);

    int updateUser(User user);

    int count(User user);

    User login(User user);

    User findUserByUserName(String username);

    String getGirlRatio();

    String getBoyRatio();

    List<NameValueVO> majorStudentNum();

    List<NameValueVO> majorStudentRatio();
    List<NameValueVO> gradeStudentNum();
    List<NameValueVO> banjiStudentNum();
    List<MajorBoyGirlNumVO> majorBoyGirlNum();
}
