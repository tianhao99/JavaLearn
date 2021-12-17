package com.tianhao.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName Cart
 * @Description TODO:购物车对象
 * @Author sth_199509@163.com
 * @Date 2021/11/16 8:45
 * @Version 1.0
 */
public class Cart {
    //Fields
    // 这两个属性因为是根据购物车中的情况确定的，不能给他赋值，
    // 所以直接用一个get方法就行了，在里面定义变量，set方法也就不能用了
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<>();
    //Constructors
    public Cart() {}

    //Methods

    /**
     * 添加商品信息
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 先查看 购物车中是否已经存在该商品，存在：价格增加，不存在：商品加入
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            // 之前没添加过此商品
            items.put(cartItem.getId(), cartItem);
        }else{
            // 已经存在
            item.setCount(item.getCount() + 1); // 数量加一
            item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));// 总价格加单价

        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        // 先查看 购物车中是否已经存在该商品，存在：修改
        CartItem item = items.get(id);
        if (item != null){
            item.setCount(count); // 数量修改
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));// 总价格加单价
        }
    }
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
