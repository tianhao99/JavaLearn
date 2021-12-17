package com.tianhao.dao.impl;

import com.tianhao.bean.Order;
import com.tianhao.dao.OrderDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDaoImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:29
 * @Version 1.0
 */
class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrderItem(){
        Order order = new Order("123456789",new Date(),new BigDecimal(100),0,1);
        orderDao.saveOrder(order);
    }
    @Test
    public void queryOrdersByUser_id(){
        List<Order> orders = orderDao.queryOrdersByUser_id(1);
        orders.forEach(System.out::println);
    }
}
