package com.example.springboot_mybatis_demo.service.impl;

import com.example.springboot_mybatis_demo.QueryVo.UserInfoVo;
import com.example.springboot_mybatis_demo.QueryVo.UserQueryVo;
import com.example.springboot_mybatis_demo.entity.User;
import com.example.springboot_mybatis_demo.mapper.UserMapper;
import com.example.springboot_mybatis_demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<User> findUserByQueryVo(UserQueryVo userQueryVo) {
        return userMapper.findUserByQueryVo(userQueryVo);
    }

    @Override
    public int findUserCount() {
        return userMapper.findUserCount();
    }

    @Override
    public List<User> findUserByIdOrName(User user) {
        return userMapper.findUserByIdOrName(user);
    }

    @Override
    public void updateSetUserById(User user) {
        userMapper.updateSetUserById(user);
    }

    @Override
    public List<UserInfoVo> findUserInfoList() {
        return userMapper.findUserInfoList();
    }

    @Override
    public List<User> selectUserInfoList(String name) {
        return userMapper.selectUserInfoList(name);
    }

}
