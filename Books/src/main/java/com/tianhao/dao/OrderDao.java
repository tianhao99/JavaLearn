package com.tianhao.dao;

import com.tianhao.bean.Order;

import java.util.List;

/**
 * @ClassName OrderDao
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:11
 * @Version 1.0
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 查询全部订单
     * @return
     */
    List<Order> queryOrder();

    /**
     * 修改订单状态，0未发货，1已发货，3已签收
     * @param order_id
     * @param status
     */
    int changeOrderStatus(String order_id,Integer status);

    /**
     * 根据用户id，查询该用户的订单信息
     * @param user_id
     * @return
     */
    List<Order> queryOrdersByUser_id(Integer user_id);
}
