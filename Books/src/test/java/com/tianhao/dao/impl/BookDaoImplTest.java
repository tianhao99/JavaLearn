package com.tianhao.dao.impl;

import com.tianhao.bean.Book;
import com.tianhao.dao.BookDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @ClassName BookDaoImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 17:04
 * @Version 1.0
 */
class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    void addBook() {
        Book onehundred = new Book(null,"百年孤独", "加西亚·马尔克斯", new BigDecimal(99),10000,89898,"static/img/onehundred.png");
        int i = bookDao.addBook(onehundred);
        System.out.println(i);
    }

    @Test
    void deleteBookById() {
        int i = bookDao.deleteBookById(3);
        System.out.println(i);
    }

    @Test
    void updateBook() {
        Book onehundred = new Book(21,"百年孤独", "加西亚·马尔克斯", new BigDecimal(99),9,899,"static/img/onehundred.png");
        int i = bookDao.updateBook(onehundred);
        System.out.println(i);
    }

    @Test
    void queryBookById() {
        Book book = bookDao.queryBookById(5);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(2, 3);
        books.forEach(System.out::println);
    }
    @Test
    public void queryForPriceTotalCount() {
        System.out.println(bookDao.queryForPriceTotalCount(5,55));
    }

    @Test
    public void queryForPricePageItems() {
        List<Book> books = bookDao.queryForPricePageItems(1,6,5, 55);
        books.forEach(System.out::println);
    }
}