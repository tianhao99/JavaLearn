package com.tianhao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JdbcUtils
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 21:29
 * @Version 1.0
 */
public class JdbcUtils {
    /**
     * 获取数据库连接池中的连接
     * @return null表示获取连接失败，有值就是成功
     */

    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    private static DataSource sourceDruid;
    //同理，将数据库连接池的创建放到外边，要不然创建n个池子干啥
    //因为涉及到流加载，不能直接声明，通过声明静态代码块，随着类的加载而加载
    static{
        try {
            Properties pros = new Properties();
            // 读取jdbc.properties 属性配置文件
//            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            pros.load(is);
            // 创建数据库连接池
            sourceDruid = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = conns.get();
        if (connection == null){
            try {
                connection = sourceDruid.getConnection();// 从数据库连接池中获取连接
                conns.set(connection); // 保存到ThreadLocal对象中，供后边的jdbc操作使用
                connection.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务，并关闭连接
     */
    public static void commitAndClose(){
        // 直接从ThreadLocal对象中获取连接，可能不存在
        Connection connection = conns.get();
        if (connection != null){ // 如果不等于null，说明之前使用过连接，操作过数据库

            try {
                // 提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 随着连接、资源的关闭，ThreadLocal对象也就没用了，【务必：关闭】（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭连接
     */
    public static void rollbackAndClose(){
        // 直接从ThreadLocal对象中获取连接，可能不存在
        Connection connection = conns.get();
        if (connection != null){ // 如果不等于null，说明之前使用过连接，操作过数据库

            try {
                // 回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 随着连接、资源的关闭，ThreadLocal对象也就没用了，【务必：关闭】（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    // 把关闭操作，放到回滚或提交中去了
//    /**
//     * 关闭连接，放回数据库连接池
//     * @param conn 要关闭的连接
//     */
//    public static void close(Connection conn){
//        try {
//            if (conn != null)
//                conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
