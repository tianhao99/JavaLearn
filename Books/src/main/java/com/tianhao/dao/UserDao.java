package com.tianhao.dao;

import com.tianhao.bean.User;

/**
 * @ClassName UserDao
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 22:57
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息【注册，判断用户名是否可用、或单纯查询信息】
     * @param username 用户名
     * @return 如果返回null，说明用户名可用，或用户不存在
     */
    public User queryUsername(String username);

    /**
     * 根据用户名和密码查询用户【登录，判断用户信息是否存在】
     * @param username
     * @param password
     * @return 如果返回null，说明用户不存在
     */
    public User queryUsernameAndPassword(String username,String password);

    /**
     * 保存注册用户的信息【注册用】
     * @param user
     * @return
     */
    public int saveUser(User user);
}
