package com.example.springboot_mybatis_demo.web;

import com.example.springboot_mybatis_demo.entity.User;
import com.example.springboot_mybatis_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis_test")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String mybatisTest1() {
        List<User> users = userService.queryUserList();
        for (User user : users) {
            log.info("-----开始遍历user-----" + user);
        }
        return "测试queryUserList方法！";
    }
}
