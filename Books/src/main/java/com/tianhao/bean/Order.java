package com.tianhao.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:02
 * @Version 1.0
 */
public class Order {
    // Fields
    private String order_id;
    private Date create_time;
    private BigDecimal price;
    private Integer status = 0;//发货状态【0未发货、1已发货、2已签收】
    private Integer user_id;

    // Constructors
    public Order() {}
    public Order(String order_id, Date createTime, BigDecimal price, Integer status, Integer user_id) {
        this.order_id = order_id;
        this.create_time = createTime;
        this.price = price;
        this.status = status;
        this.user_id = user_id;
    }

    // Methods
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date createTime) {
        this.create_time = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", createTime=" + create_time +
                ", price=" + price +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
