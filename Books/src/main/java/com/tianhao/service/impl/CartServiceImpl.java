package com.tianhao.service.impl;

import com.tianhao.bean.CartItem;
import com.tianhao.service.CartService;

/**
 * @ClassName CartServiceImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 9:02
 * @Version 1.0
 */
public class CartServiceImpl implements CartService {
    @Override
    public void addItem(CartItem cartitem) {
        // 先查看 购物车中是否已经存在该商品，存在：价格增加，不存在：商品加入
        System.out.println("商品编号：");
    }

    @Override
    public void deleteItem(Integer id) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void updateCount(Integer id, Integer count) {

    }
}
