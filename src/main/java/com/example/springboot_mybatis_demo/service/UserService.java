package com.example.springboot_mybatis_demo.service;

import com.example.springboot_mybatis_demo.QueryVo.UserInfoVo;
import com.example.springboot_mybatis_demo.QueryVo.UserQueryVo;
import com.example.springboot_mybatis_demo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    public List<User> queryUserList();

    public void insertUser(User user);

    public void deleteUserById(Long id);

    public void updateUserById(User user);

    public List<User> findUserByName(String name);

    public List<User> findUserByQueryVo(UserQueryVo userQueryVo);

    public int findUserCount();

    public List<User> findUserByIdOrName(User user);

    public void updateSetUserById(User user);

    public List<UserInfoVo> findUserInfoList();

    public List<User> selectUserInfoList(String name);

}
