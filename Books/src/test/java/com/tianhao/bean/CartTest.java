package com.tianhao.bean;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName CartTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 9:45
 * @Version 1.0
 */
class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"浮生六记",1,new BigDecimal(199),new BigDecimal(99)));
        cart.addItem(new CartItem(1,"浮生六记",1,new BigDecimal(199),new BigDecimal(99)));
        cart.addItem(new CartItem(2,"百年孤独",1,new BigDecimal(199),new BigDecimal(99)));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
    }

    @Test
    void clear() {
    }

    @Test
    void updateCount() {
    }
}