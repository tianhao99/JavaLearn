package com.tianhao.dao;

import com.tianhao.bean.OrderItem;

import java.util.List;

/**
 * @ClassName OrderItemDao
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:12
 * @Version 1.0
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查询 订单的详细信息
     * @param order_id
     * @return
     */
    List<OrderItem> queryOrderItemsByOrder_id(String order_id);
}
