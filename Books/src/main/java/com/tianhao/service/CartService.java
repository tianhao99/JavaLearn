package com.tianhao.service;

import com.tianhao.bean.Cart;
import com.tianhao.bean.CartItem;

/**
 * @ClassName CartService
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 8:52
 * @Version 1.0
 */
public interface CartService {
    /**
     * 添加商品
     * @param cartItem
     */
    void addItem(CartItem cartItem);

    /**
     * 根据ID删除商品
     * @param id
     */
    void deleteItem(Integer id);

    /**
     * 清空购物车
     */
    void clear();

    /**
     * 修改购物车产品数量
     * @param id
     * @param count
     */
    void updateCount(Integer id,Integer count);

}
