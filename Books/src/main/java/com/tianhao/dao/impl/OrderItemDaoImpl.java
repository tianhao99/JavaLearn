package com.tianhao.dao.impl;

import com.tianhao.bean.OrderItem;
import com.tianhao.dao.OrderItemDao;

import java.util.List;

/**
 * @ClassName OrderItemDaoImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:13
 * @Version 1.0
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_Price(),orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrder_id(String order_id) {
        String sql = "select * from t_order_item where `order_id`=?";
        return queryForList(OrderItem.class,sql,order_id);
    }
}
