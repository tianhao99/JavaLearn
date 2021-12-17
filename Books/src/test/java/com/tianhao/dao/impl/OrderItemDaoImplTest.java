package com.tianhao.dao.impl;

import com.tianhao.bean.OrderItem;
import com.tianhao.dao.OrderItemDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName OrderItemDaoImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:25
 * @Version 1.0
 */
class OrderItemDaoImplTest {

    @Test
    void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(199),new BigDecimal(88),"123456789"));
    }
}