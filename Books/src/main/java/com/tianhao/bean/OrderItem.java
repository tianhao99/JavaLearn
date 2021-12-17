package com.tianhao.bean;

import java.math.BigDecimal;

/**
 * @ClassName OrderItem
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:07
 * @Version 1.0
 */
public class OrderItem {
    // Fields
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal total_Price;
    private String order_id;

    // Constructors
    public OrderItem(){}
    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal total_Price, String order_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_Price = total_Price;
        this.order_id = order_id;
    }

    // Methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(BigDecimal total_Price) {
        this.total_Price = total_Price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total_Price=" + total_Price +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
