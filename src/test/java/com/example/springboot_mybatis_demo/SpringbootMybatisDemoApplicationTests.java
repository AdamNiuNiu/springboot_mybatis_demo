package com.example.springboot_mybatis_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatis_demo.entity.User;
import com.example.springboot_mybatis_demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SpringbootMybatisDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        log.info("================进入方法testSelect===============");
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            log.info("-----开始遍历user-----" + user);
        }
    }


    @Test
    public void testSelectByLike() {
        QueryWrapper queryWrapper = new QueryWrapper(new User());
        queryWrapper.like("name", "o");
        List<User> users = this.userMapper.selectList(queryWrapper);
        for (User user : users) {
            log.info("-----开始遍历user-----" + user);
        }
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setName("zhangsansan");
        user.setAge(11);
        user.setEmail("zhangsansan@qq.com");
        int insert = userMapper.insert(user);
        log.info("------新增数据成功-------count--------" + insert);
    }


    @Test
    public void testDelete() {
        this.userMapper.deleteById(7L);
        System.out.println("删除成功!");
    }


    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setName("lisi");
        this.userMapper.updateById(user);
        System.out.println("修改成功!");
    }


    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = this.userMapper.selectPage(page, null);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<User> records = userIPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }


    @Test
    public void testSelectAllByUserMapperxml() {
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            log.info("-----开始遍历user-----" + user);
        }
    }
}
