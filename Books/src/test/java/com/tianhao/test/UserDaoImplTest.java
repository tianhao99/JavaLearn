package com.tianhao.test;

import com.tianhao.bean.User;
import com.tianhao.dao.UserDao;
import com.tianhao.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;


/**
 * @ClassName UserDaoImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 23:13
 * @Version 1.0
 */
class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    void queryUsername() {
        System.out.println(userDao.queryUsername("张三丰"));
        System.out.println(userDao.queryUsername("张无忌"));
        if (userDao.queryUsername("admin") == null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    void queryUsernameAndPassword() {
        User user = userDao.queryUsernameAndPassword("admin","admin");
        if (user == null){
            System.out.println("用户或密码错误，登录失败！");
        }else{
            System.out.println(user);
            System.out.println("登录成功");
        }
    }

    @Test
    void saveUser() {
        User user = new User("张三丰", "guoxiang", "guoxiang@qq.com");
        if (userDao.saveUser(user) != -1){
            System.out.println("注册成功！");
        }else{
            System.out.println("注册失败！");
        }

    }
}