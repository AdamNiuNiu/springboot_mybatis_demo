package com.example.springboot_mybatis_demo.web;

import com.example.springboot_mybatis_demo.QueryVo.UserInfoVo;
import com.example.springboot_mybatis_demo.QueryVo.UserQueryVo;
import com.example.springboot_mybatis_demo.entity.User;
import com.example.springboot_mybatis_demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    @RequestMapping(value = "insertUser",method = RequestMethod.POST)
    public String insertUser(User user) {
        log.info("-----开始插入user-----");
        userService.insertUser(user);
        return "测试插入user方法！";
    }


    @RequestMapping(value = "deleteUserById",method = RequestMethod.POST)
    public String deleteUserById(Long id) {
        log.info("-----开始删除user-----");
        userService.deleteUserById(id);
        return "删除user方法！";
    }


    @RequestMapping(value = "updateUserById",method = RequestMethod.POST)
    public String updateUserById(User user) {
        log.info("-----开始更新user-----");
        userService.updateUserById(user);
        return "更新user方法！";
    }


    @RequestMapping(value = "findUserByName",method = RequestMethod.POST)
    public Integer findUserByName(String name) {
        log.info("-----开始模糊查询user-----");
        List<User> list = userService.findUserByName(name);
        for (User user : list) {
            log.info("-----"+user.toString()+"-----");
        }
        return list.size();
    }


    @RequestMapping(value = "findUserByQueryVo",method = RequestMethod.POST)
    public Integer findUserByQueryVo(UserQueryVo userQueryVo) {
        log.info("-----开始模查询findUserByQueryVo-----");
        List<User> list = userService.findUserByQueryVo(userQueryVo);
        for (User user : list) {
            log.info("-----"+user.toString()+"-----");
        }
        return list.size();
    }


    @RequestMapping(value = "findUserCount",method = RequestMethod.POST)
    public Integer findUserCount() {
        log.info("-----开始findUserCount-----");
        int i= userService.findUserCount();
            log.info("-----"+i+"-----");
        return i;
    }


    @RequestMapping(value = "findUserByIdOrName",method = RequestMethod.POST)
    public Integer findUserByIdOrName(User user) {
        log.info("-----开始findUserByIdOrName-----");
        List<User> list = userService.findUserByIdOrName(user);
        for (User user2 : list) {
            log.info("-----"+user2.toString()+"-----");
        }
        return list.size();
    }


    @RequestMapping(value = "updateSetUserById",method = RequestMethod.POST)
    public Integer updateSetUserById(User user) {
        log.info("-----开始updateSetUserById-----");
        if(user.getId()==null) {
            return 0;
        }
        userService.updateSetUserById(user);
        return 1;
    }


    @RequestMapping(value = "findUserInfoList",method = RequestMethod.POST)
    public Integer findUserInfoList() {
        log.info("-----开始findUserInfoList-----");
        List<UserInfoVo> list = userService.findUserInfoList();
        for (UserInfoVo userInfoVo : list) {
            log.info("-----"+userInfoVo.toString()+"-----");
        }
        return list.size();
    }


    @RequestMapping(value = "selectUserInfoList",method = RequestMethod.POST)
    public PageInfo<User> selectUserInfoList(Integer pageIndex, Integer pageSize, String name) {
        log.info("-----开始findUserInfoList-----");
        //注意PageHelper.startPage的位置，一定要在查询的前面
        PageHelper.startPage(pageIndex,pageSize).setOrderBy("id desc");
        List<User> list = userService.selectUserInfoList(name);
        PageInfo<User> userPageInfo = new PageInfo<>(list);
        for (User user : list) {
            log.info("-----"+user.toString()+"-----");
        }
        return userPageInfo;
    }
}
