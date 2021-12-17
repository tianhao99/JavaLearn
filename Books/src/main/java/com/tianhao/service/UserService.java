package com.tianhao.service;

import com.tianhao.bean.User;

/**
 * @ClassName UserService
 * @Description TODO:要实现哪些功能？检查用户名是否合法？账户是否存在？
 * @Author sth_199509@163.com
 * @Date 2021/11/9 7:43
 * @Version 1.0
 */
public interface UserService {
    /**
     * 注册账户信息
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录操作
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true，表示存在，用户名不可用，返回false表示可用
     */
    public boolean existsUsername(String username);
}
