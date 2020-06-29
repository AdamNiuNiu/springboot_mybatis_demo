package com.example.springboot_mybatis_demo.service;

import com.example.springboot_mybatis_demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserList();
}
