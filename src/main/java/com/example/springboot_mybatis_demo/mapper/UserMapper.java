package com.example.springboot_mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_mybatis_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<User> queryUserList();
}
