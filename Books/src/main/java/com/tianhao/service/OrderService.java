package com.tianhao.service;

import com.tianhao.bean.Cart;
import com.tianhao.bean.Order;
import com.tianhao.bean.OrderItem;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:36
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param user_id
     * @return
     */
    String createOrder(Cart cart,Integer user_id);

    /**
     * 展示全部订单
     * @return
     */
    List<Order> showAllOrders();

    /**
     * 发货，设置status = 1
     * @param order_id
     */
    void sendOrder(String order_id);

    /**
     * 根据id显示订单详情
     * @param order_id
     * @return
     */
    List<OrderItem> showOrderDetail(String order_id);

    /**
     * 根据用户id，查询当前用户所有的订单信息
     * @param user_id
     * @return
     */
    List<Order> showMyOrders(Integer user_id);

    /**
     * 确认收货，置status = 3
     * @param order_id
     */
    void receiverOrder(String order_id);
}
