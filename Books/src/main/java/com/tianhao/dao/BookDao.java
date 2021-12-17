package com.tianhao.dao;

import com.tianhao.bean.Book;

import java.util.List;

/**
 * @ClassName BookDao
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 16:38
 * @Version 1.0
 */
public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 根据ID删除图书
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     * 更改图书信息
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 根据ID查找图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();

    /**
     * 查询数据库中所有记录数
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 查询当前页面能够显式的book集合
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 查询总记录数，价格区间在min--max之间的
     * @return
     */
    Integer queryForPriceTotalCount(int min,int max);

    /**
     * 查询当前页面能够显式的book集合【price范围在min和max之间】
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPricePageItems(int begin, int pageSize,int min,int max);
}
