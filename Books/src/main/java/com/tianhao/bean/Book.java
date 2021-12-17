package com.tianhao.bean;

import java.math.BigDecimal;

/**
 * @ClassName Book
 * @Description TODO:图书JavaBean
 * @Author sth_199509@163.com
 * @Date 2021/11/12 16:24
 * @Version 1.0
 */
public class Book {
    // Fields
    /**
     *      `id` int primary key auto_increment,    -- 序列
     * 		`name` varchar(50),											-- 书名
     * 		`price` decimal(11,2),									-- 价格
     * 		`author` varchar(50),										-- 作者
     * 		`sales` int,														-- 销量
     * 		`stock` int,														-- 库存
     * 		`img_path` varchar(200)									-- 图书照片
     */
    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String img_path = "static/img/default.jpg"; // 确保有一个默认的封面
    // 后边赋值操作也是，先判断是不是空，非空再赋值，空，就不赋值，还是用原来的默认封面

    // Constructors
    public Book() {}
    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if (img_path != null && !"".equals(img_path)) // 如果传进来的不是空地址，且不是null，就允许赋值，否则就用默认封面值
            this.img_path = img_path;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        if (img_path != null && !"".equals(img_path)) // 如果传进来的不是空地址，且不是null，就允许赋值，否则就用默认封面值
            this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
