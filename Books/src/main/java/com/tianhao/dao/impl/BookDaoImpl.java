package com.tianhao.dao.impl;

import com.tianhao.bean.Book;
import com.tianhao.dao.BookDao;

import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 16:45
 * @Version 1.0
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where `id`=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where `id`=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number value = (Number) queryForSingleValue(sql);// 返回值只能是long或者Number类型
        return value.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPriceTotalCount(int min,int max) {
        String sql = "select count(*) from t_book where `price` > ? and `price` < ?";
//        String sql = "select count(*) from t_book where `price` between ? and ?";
        Number count = (Number)queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPricePageItems(int begin, int pageSize, int min, int max) {
        String sql = "select * from t_book where `price` between ? and ? order by `price` limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}
