package com.tianhao.dao.impl;

import com.tianhao.bean.Order;
import com.tianhao.dao.OrderDao;

import java.util.List;

/**
 * @ClassName OrderDaoImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:13
 * @Version 1.0
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public List<Order> queryOrder() {
        String sql = "select * from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public int changeOrderStatus(String order_id, Integer status) {
        String sql = "update t_order set `status`=? where `order_id`=?";
        return update(sql,status,order_id);
    }

    @Override
    public List<Order> queryOrdersByUser_id(Integer user_id) {
        String sql = "select * from t_order where `user_id`=?";
        return queryForList(Order.class,sql,user_id);
    }
}
