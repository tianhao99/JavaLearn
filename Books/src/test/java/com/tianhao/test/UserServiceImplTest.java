package com.tianhao.test;

import com.tianhao.bean.User;
import com.tianhao.service.UserService;
import com.tianhao.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName UserServiceImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/9 8:00
 * @Version 1.0
 */
class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    void registUser() {
        User user = new User(null,"杨过","xiaolongnv","xiaolongnv@126.com");
        userService.registUser(user);
    }

    @Test
    void login() {
        User user = new User(null, "admin", "admin", "12345@qq.com");
        userService.login(user);
    }

    @Test
    void existsUsername() {
        if (userService.existsUsername("张无忌")){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }
    }
}