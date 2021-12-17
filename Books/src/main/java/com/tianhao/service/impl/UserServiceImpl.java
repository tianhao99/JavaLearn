package com.tianhao.service.impl;

import com.tianhao.bean.User;
import com.tianhao.dao.UserDao;
import com.tianhao.dao.impl.UserDaoImpl;
import com.tianhao.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO:UserService接口的实现类
 * @Author sth_199509@163.com
 * @Date 2021/11/9 7:50
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    // 因为相应的功能需要 操作数据库，所以创建一个UserDaoImpl类的对象
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUsername(username) == null){
            // 说明没查到，表示可用，返回false
            // 为什么要返回false呢？因为方法名是，existsUsername【存在用户A吗，不存在返回false】
            return false;
        }else{
            return true;
        }
    }
}
