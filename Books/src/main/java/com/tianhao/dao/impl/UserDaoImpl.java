package com.tianhao.dao.impl;

import com.tianhao.bean.User;
import com.tianhao.dao.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 23:03
 * @Version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`=? And `password`=?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`)value(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
