package com.tianhao.dao.impl;

import com.tianhao.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BaseDao
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 22:30
 * @Version 1.0
 */
public abstract class BaseDao {
    // 使用DbUtils 操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update用来实现 insert/update/delete语句
     * @param sql sql语句
     * @param args 占位符
     * @return 如果返回-1，表示执行失败，否则返回受影响行数
     */
    public int update(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args); // 返回受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个JavaBean的sql语句
     * @param type 返回对象类型
     * @param sql 执行的SQL语句
     * @param args 占位符，SQL语句的参数
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询多个结果，返回对象数组
     * @param type 返回对象类型
     * @param sql 执行的SQL语句
     * @param args 占位符，SQL语句的参数
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个值，最大值、最小值、总行数之类的
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
